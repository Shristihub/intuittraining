package com.productuser.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.productuser.service.JwtUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	// authentication
	@Bean
	UserDetailsService userDetailsService() {
		return new JwtUserServiceImpl();
	}

	// password encoder
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	// authentication manager
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	// authorization
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/product-api/v1/admin/**").hasAuthority("ADMIN")
						.requestMatchers("/product-api/v1/user/**").hasAnyAuthority("ADMIN", "USER")
						.requestMatchers("/jwtuser-api/v1/register", "/jwtuser-api/v1/login").permitAll()
						.anyRequest().authenticated())

				// use Jwtauthenticationentry point to send errors
				.exceptionHandling(configurer -> configurer.authenticationEntryPoint(authenticationEntryPoint))

				// session is stateless here - do not handle session
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				// move to the filter in the flow
				// the requestfilter will be called before usernamepasswordfilter
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}

}

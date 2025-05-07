package com.productuser.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productuser.model.JwtUser;
import com.productuser.model.JwtUserDto;
import com.productuser.repository.IJwtUserRepository;

@Service
public class JwtUserServiceImpl implements UserDetailsService{
	
	@Autowired
	private IJwtUserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// check if user email exists in the database
		JwtUser jwtUser =  userRepository.findByUsername(username)
			.orElseThrow(()-> new UsernameNotFoundException("invalid email"));
		return jwtUser;
	}

	public JwtUser createUser(JwtUser jwtUser) {
		JwtUser newUser = userRepository.save(jwtUser);
		return newUser;
		
	}


}

package com.productuser.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class JwtUser implements UserDetails{
	@Id
	@GeneratedValue
	private Integer userId;
	private String username;
	private String password;
	private String email;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "jwtuser_roles",joinColumns = {
			@JoinColumn(name="user_id")
	})
	List<String> roles;
	public JwtUser(String username, String password, String email, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = 
			     roles.stream().map(role->new SimpleGrantedAuthority(role)).toList();
		 return authorities;
	}
	
	
}




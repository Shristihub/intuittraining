package com.productuser.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productuser.model.JwtUser;
import com.productuser.model.JwtUserDto;
import com.productuser.service.JwtUserServiceImpl;
import com.productuser.util.JwtTokenUtil;

@RestController
@RequestMapping("/jwtuser-api/v1")
public class UserController {
	
	@Autowired
	private JwtUserServiceImpl userServiceImpl;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	 @PostMapping("/register")
	 ResponseEntity<JwtUserDto> addUser(@RequestBody JwtUserDto userDto){
		// dto to entity
		 String password = passwordEncoder.encode(userDto.getPassword());
		 userDto.setPassword(password);		 
		JwtUser jwtUser = mapper.map(userDto, JwtUser.class); 
		JwtUser savedUser = userServiceImpl.createUser(jwtUser);
		
		// entity to dto
		JwtUserDto newUserDto = mapper.map(savedUser, JwtUserDto.class);
		return ResponseEntity.ok(newUserDto);
	}
	 
	 @PostMapping("/login")
	 ResponseEntity<String> authenticateUser(@RequestBody JwtUserDto userDto){ 
		 // check if username exists
		 UserDetails userDetails = 
				 userServiceImpl.loadUserByUsername(userDto.getUsername());
		 // generate token by passing the userdetails object
		 String token = jwtTokenUtil.generateToken(userDetails);
		 return ResponseEntity.ok(token);
	 }
	 
	 
	 
	 
}

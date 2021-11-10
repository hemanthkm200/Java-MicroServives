package com.javafsd.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javafsd.jwtsecurity.entity.JwtRequest;
import com.javafsd.jwtsecurity.entity.JwtResonse;
import com.javafsd.jwtsecurity.jwtutill.JwtUtility;
import com.javafsd.jwtsecurity.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private JwtUtility jwtutil;

	@Autowired
	private UserService userservice;

	@Autowired
	private AuthenticationManager authenticationmanager;

	@GetMapping("/")
	public String home() {
		return "Hey Welcome To JAVAFSD";

	}

	@PostMapping("/authenticate")
	public JwtResonse authenticate(@RequestBody JwtRequest jwtrequest)throws Exception {
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUserName(),jwtrequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credeintial", e);
		}

		final UserDetails userDetails =userservice.loadUserByUsername(jwtrequest.getUserName());
		final String token =jwtutil.generateToken(userDetails);
		return new JwtResonse(token);
	}

}

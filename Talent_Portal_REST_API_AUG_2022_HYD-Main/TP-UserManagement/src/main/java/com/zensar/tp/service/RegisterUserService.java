package com.zensar.tp.service;

import org.springframework.stereotype.Service;

import com.zensar.tp.dto.RegisterUser;

@Service
public interface RegisterUserService { 
	public RegisterUser createNewUser(RegisterUser user);



}
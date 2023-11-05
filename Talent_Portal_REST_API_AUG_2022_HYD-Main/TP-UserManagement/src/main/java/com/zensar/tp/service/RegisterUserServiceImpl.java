package com.zensar.tp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.tp.dto.RegisterUser;

import com.zensar.tp.entity.UserEntity;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.repo.UserRepo;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
	@Autowired
	UserRepo userRepo;
	
	ModelMapper mapper=new ModelMapper();
	
	@Override
	public RegisterUser createNewUser(RegisterUser user) {
		if((user.getFirstName()!= null) && (user.getLastName()!= null) && (user.getUsername()!= null) && 
				(user.getEmail()!= null) && (user.getPassword()!= null) && (user.getPhone()!= null)) {
			if(!userRepo.existsByUsername(user.getUsername()))
			{
			UserEntity entity=mapper.map(user,UserEntity.class);
			entity=userRepo.save(entity);
			user=mapper.map(entity, RegisterUser.class);
			return user;
			}
			throw new InvalidUserDataException("Username already exists");
		}
		throw new InvalidUserDataException( );
	}
}
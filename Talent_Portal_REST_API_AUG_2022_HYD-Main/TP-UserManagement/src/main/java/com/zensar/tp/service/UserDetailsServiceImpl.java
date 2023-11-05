package com.zensar.tp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.entity.UserEntity;
import com.zensar.tp.repo.UserRepo;



@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService{
@Autowired
UserRepo userRepo;
@Autowired
ModelMapper mapper;
@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserEntity> userEntityList=userRepo.findByUsername(username);
		if(userEntityList==null||userEntityList.size()==0) {
			throw new UsernameNotFoundException(username);
		}
		
		UserEntity userEntity=userEntityList.get(0);
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
		
		User user=new User(userEntity.getUsername(),userEntity.getPassword(),authorities);
		return user;
	}
@Override
public List<RegisterUser> findUserByUsername(String username) throws UsernameNotFoundException {
    List<UserEntity>userEntityList = userRepo.findByUsername(username);
    return userEntityList.stream().map(i -> mapper.map(i, RegisterUser.class)).collect(Collectors.toList());
  
}    


	
}

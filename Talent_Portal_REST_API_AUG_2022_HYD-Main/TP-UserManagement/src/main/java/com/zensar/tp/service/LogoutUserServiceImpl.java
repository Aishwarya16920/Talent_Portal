package com.zensar.tp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.tp.entity.BlackListEntity;
import com.zensar.tp.repo.BlackListRepo;

@Service
public class LogoutUserServiceImpl implements LogutUserService{
    @Autowired
    BlackListRepo blackListRepo;    
    
    @Override
    public boolean logoutUser(String auth) {
        BlackListEntity blackListEntity=new BlackListEntity(auth, LocalDate.now());
        blackListEntity=blackListRepo.save(blackListEntity);
        return true;
    }
    @Override
    public boolean check(String auth) {
    	List<BlackListEntity> token=new ArrayList<>();
    	token=blackListRepo.findAll();
    	String token1=token.toString();
    	for(BlackListEntity i:token) {
    	if(i.getAuth().contains(auth)) {
    		return true;
    	}
    	}
return false;
    }
}
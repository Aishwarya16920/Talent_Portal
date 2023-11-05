package com.zensar.tp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zensar.tp.dto.RegisterUser;

public interface UserService {
    List<RegisterUser> findUserByUsername(String username) throws UsernameNotFoundException;
}
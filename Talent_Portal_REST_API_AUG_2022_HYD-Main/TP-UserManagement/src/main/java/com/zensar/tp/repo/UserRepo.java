package com.zensar.tp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.tp.entity.UserEntity;



public interface UserRepo extends JpaRepository<UserEntity,Integer> {
	
	List<UserEntity> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}

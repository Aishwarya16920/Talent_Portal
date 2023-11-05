package com.zensar.tp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entity.BlackListEntity;

@Repository
public interface BlackListRepo extends JpaRepository<BlackListEntity,Integer> {



}
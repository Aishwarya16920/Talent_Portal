package com.zensar.tp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entity.ApplicationStatusEntity;

@Repository
public interface ApplicationStatusRepo extends JpaRepository<ApplicationStatusEntity, Integer> {

}
package com.zensar.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entities.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer>{
	List<JobEntity> findByUsername(String username);
}
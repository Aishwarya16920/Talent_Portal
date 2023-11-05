package com.zensar.tp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entity.ApplicationStatusEntity;
import com.zensar.tp.entity.JobApplication;

@Repository
public interface JobApplicationStatusRepo extends JpaRepository<JobApplication, Integer> {

}
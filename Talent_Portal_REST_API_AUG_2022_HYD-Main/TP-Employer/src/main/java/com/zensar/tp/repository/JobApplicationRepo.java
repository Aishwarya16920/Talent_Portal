package com.zensar.tp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entities.JobApplicationEntity;

@Repository
    public interface JobApplicationRepo extends JpaRepository<JobApplicationEntity, Integer> {

public Boolean existsByJobId (int job_id);
public List<JobApplicationEntity> findByJobId(int jobId);
public Boolean existsByUserNameAndJobId(String userName, int jobId);
  }
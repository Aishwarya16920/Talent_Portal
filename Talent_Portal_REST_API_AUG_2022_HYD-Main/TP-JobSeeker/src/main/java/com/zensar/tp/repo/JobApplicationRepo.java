package com.zensar.tp.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.zensar.tp.entity.JobApplicationEntity;



   @Repository
    public interface JobApplicationRepo extends JpaRepository<JobApplicationEntity, Integer> {

	  
	   public List<JobApplicationEntity> findByUserName(String userName);
  }

package com.zensar.tp.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entity.JobEntity;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer>{
	public Boolean existsByUsername(String username);
	@Query("SELECT primarySkill FROM JobEntity primarySkill WHERE " +
            "primarySkill.primarySkill LIKE CONCAT('%',:primarySkill, '%')")
	List<JobEntity> findByprimarySkill(String primarySkill);
	
}
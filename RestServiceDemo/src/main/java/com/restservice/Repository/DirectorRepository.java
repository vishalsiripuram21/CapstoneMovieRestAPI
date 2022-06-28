package com.restservice.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restservice.Entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

	@Query("from Director  where first_Name=?1 and last_Name=?2")
	public Director findMovieByDirector(String first_Name,String last_Name);
	
	
	@Modifying
	@Query("update Director set Address=:Address,Contact_Number=:Contact_Number where First_Name=:First_Name and Last_Name=:Last_Name")
	public Integer updateDirectorDetails(String First_Name,String Last_Name,String Address,String Contact_Number);
	

	
}

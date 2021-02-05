package com.moon.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moon.admin.domain.MoonImage;

public interface MoonImageRepository extends JpaRepository<MoonImage, Long> {
	
	@Query("SELECT i FROM MoonImage i where i.imageGroup = :groupNo") 
    List<MoonImage> findImagesByGroup(@Param("groupNo") int groupNo);
	
}

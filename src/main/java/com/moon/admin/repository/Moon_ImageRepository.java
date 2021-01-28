package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moon.admin.domain.Moon_Images;

@Repository
public interface Moon_ImageRepository extends JpaRepository<Moon_Images, Long> {

}

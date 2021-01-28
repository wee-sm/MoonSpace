package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moon.admin.domain.Moon_Projects;

@Repository
public interface Moon_ProjectsRepository extends JpaRepository<Moon_Projects, Long> {

}

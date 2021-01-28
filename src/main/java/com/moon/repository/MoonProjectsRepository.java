package com.moon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.domain.MoonProjects;

public interface MoonProjectsRepository extends JpaRepository<MoonProjects, Long> {

}

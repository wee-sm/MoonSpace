package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.admin.domain.MoonProjects;

public interface MoonProjectsRepository extends JpaRepository<MoonProjects, Long> {

}

package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.admin.domain.MoonProject;

public interface MoonProjectRepository extends JpaRepository<MoonProject, Long> {

}

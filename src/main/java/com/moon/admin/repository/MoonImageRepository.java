package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.admin.domain.MoonImages;

public interface MoonImageRepository extends JpaRepository<MoonImages, Long> {

}

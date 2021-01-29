package com.moon.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.admin.domain.MoonImage;

public interface MoonImageRepository extends JpaRepository<MoonImage, Long> {

}

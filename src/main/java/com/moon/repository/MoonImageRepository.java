package com.moon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moon.domain.MoonImages;

public interface MoonImageRepository extends JpaRepository<MoonImages, Long> {

}

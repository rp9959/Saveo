package com.saveo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saveo.model.UrlBean;

public interface UrlRepository extends JpaRepository<UrlBean, Long> {
	
	 Optional<UrlBean> findById(String id);

}

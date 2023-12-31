package com.fdmgroup.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.springboot.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
	boolean existsByTitle(String title); 
}

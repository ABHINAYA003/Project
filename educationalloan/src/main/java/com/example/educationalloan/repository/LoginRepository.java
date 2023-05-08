package com.example.educationalloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educationalloan.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,String>{
	Login findByEmail(String email);
} 

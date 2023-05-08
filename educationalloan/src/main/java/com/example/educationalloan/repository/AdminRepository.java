package com.example.educationalloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educationalloan.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String>{

}



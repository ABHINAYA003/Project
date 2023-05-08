package com.example.educationalloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educationalloan.model.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Integer>{

} 


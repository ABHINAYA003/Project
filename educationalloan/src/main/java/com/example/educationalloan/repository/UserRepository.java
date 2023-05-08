package com.example.educationalloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.educationalloan.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}



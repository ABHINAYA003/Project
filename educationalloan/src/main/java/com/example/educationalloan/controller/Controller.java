package com.example.educationalloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.educationalloan.model.Admin;
import com.example.educationalloan.model.LoanApplication;
import com.example.educationalloan.model.Login;
import com.example.educationalloan.model.User;
import com.example.educationalloan.service.Services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class Controller {
	@Autowired
	Services userService;
	@Operation(summary = "Get all the details")

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "data fetched successfully"),

			@ApiResponse(responseCode = "401", description = "Invalid credentials"),

			@ApiResponse(responseCode = "404", description = "Path not found") })

	
	
	@GetMapping(value="/fetchLogin")
	public List<Login> getAllLogin()
	{
		return userService.getAllLogin();
	}
	
	 @PostMapping("/addUser")
	 public Login saveUser(@RequestBody Login l)
	 {
	    return userService.saveUser(l);
	 }
	 
	 @GetMapping(value="/fetchAdmin")
	 public List<Admin> getAllAdmin()
	 {
		 return userService.getAllAdmin();
	 }
	 
	 @GetMapping(value="/fetchLoan")
	 public List<LoanApplication> getAllLoans()
	 {
		 return userService.getAllLoans();
	 }
	 
	 @PostMapping("/checkLogin")
		public String validateUser(@RequestBody Login l)
		{
		System.out.println(l.getEmail());
			return userService.validateUser(l.getEmail(),l.getPassword());
		}
	 
	 @PostMapping("/saveLoan")
	 public LoanApplication saveLoan(@RequestBody LoanApplication s) {
			LoanApplication obj=userService.saveLoan(s);
			return obj;
		}
	 
	 @PutMapping("/updateLoan/{loanId}")
		public LoanApplication updateLoan(@RequestBody LoanApplication s,@PathVariable int loanId) {
			 return userService.updateLoan(s,loanId);
		}

	 @DeleteMapping("/deleteLoan/{id}")
		public void deleteLoan(@PathVariable int id) {
			userService.deleteLoan(id);
		}
	 
	 @GetMapping(value="/fetchUser")
	 public List<User> getAllUser()
	 {
		 return userService.getAllUser();
	 }
	 
	 @PostMapping("/saveUser")
	 public User saveUser(@RequestBody User s) {
			return userService.saveUser(s);
		}
	 
	 @PutMapping("/updateUser/{id}")
		public User updateUser(@RequestBody User s,@PathVariable int id) {
			 return userService.updateUser(s,id);
		}

	 @DeleteMapping("/deleteUser/{id}")
		public void deleteUser(@PathVariable int id) {
			userService.deleteUser(id);
		}
}

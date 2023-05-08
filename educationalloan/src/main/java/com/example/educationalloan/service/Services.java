package com.example.educationalloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educationalloan.model.Admin;
import com.example.educationalloan.model.LoanApplication;
import com.example.educationalloan.model.Login;
import com.example.educationalloan.model.User;
import com.example.educationalloan.repository.AdminRepository;
import com.example.educationalloan.repository.LoanApplicationRepository;
import com.example.educationalloan.repository.LoginRepository;
import com.example.educationalloan.repository.UserRepository;

@Service
public class Services {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	LoanApplicationRepository loanRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Login saveUser(Login l)
	{
		return loginRepository.save(l);
	}
	
	public String validateUser(String email,String password)
	{
		String result="";
		Login l=loginRepository.findByEmail(email);
		if(l==null)
		{
			result="Invalid email";
		}
		else
		{
			if(l.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
		return result;
	}

	public List<Login> getAllLogin() {
		return loginRepository.findAll();
	}
	
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}
	
	//loanApplication
	public List<LoanApplication> getAllLoans() {
		return loanRepo.findAll();
	}
	
	public LoanApplication saveLoan(LoanApplication s) {
		LoanApplication obj=loanRepo.save(s);
		return obj;
	}

	public LoanApplication updateLoan(LoanApplication s,int loanId) {
		 Optional<LoanApplication> data=loanRepo.findById(loanId);
		 if(data.isPresent())
		 {
			 return loanRepo.save(s);
		 }
		 return null;	 
	}

	public void deleteLoan(int loanId) {
		loanRepo.deleteById(loanId);
	}
	
	//User
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	public User saveUser(User s) {
		User obj=userRepo.save(s);
		return obj;
	}

	public User updateUser(User s,int id)
	{
		Optional<User> data=userRepo.findById(id);
		if(data.isPresent())
		{
			return userRepo.save(s);
		}
		return null;
	}

	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
}

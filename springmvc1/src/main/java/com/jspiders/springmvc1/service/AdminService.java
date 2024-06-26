package com.jspiders.springmvc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

	public AdminPOJO getAdmin() {
		AdminPOJO pojo = repository.getAdmin();
		return pojo;
	}

	public AdminPOJO createAccount(String username, String email,long contact,String city, String password, String confirmPassword) {
		AdminPOJO pojo = repository.createAccount(username, email, contact, city, password, confirmPassword);
		return pojo;
	}

	public AdminPOJO login(String username, String password) {
		AdminPOJO pojo = repository.login(username, password);
		return pojo;
	}

}
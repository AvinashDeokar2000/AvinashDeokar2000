package com.jspiders.employeemanagementsystem_springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.employeemanagementsystem_springmvc.pojo.EmployeePOJO;
import com.jspiders.employeemanagementsystem_springmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public EmployeePOJO addEmployee(String name, String email, long contact, String address) {
		EmployeePOJO pojo= repository.addEmployee(name, email, contact, address);
		return pojo;
	}
	
	public List<EmployeePOJO> findAllEmployees() {
		List<EmployeePOJO> employees= repository.findAllEmployees();
			return employees;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO pojo=repository.searchEmployee(id);
		return pojo;
	}

	public EmployeePOJO removeEmployee(int id) {
		EmployeePOJO pojo = repository.removeEmployee(id);
		return pojo;
	}

	public EmployeePOJO updateEmployee(int id, String name, String email, long contact, String address) {
		EmployeePOJO pojo= repository.updateEmployee(id, name, email, contact, address);
		return pojo;
	}

	
	
	

}

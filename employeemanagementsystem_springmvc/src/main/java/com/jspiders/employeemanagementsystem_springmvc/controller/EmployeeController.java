package com.jspiders.employeemanagementsystem_springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.employeemanagementsystem_springmvc.pojo.EmployeePOJO;
import com.jspiders.employeemanagementsystem_springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/home")
	public String homePage() {
		return "Home";
	}
	
	@GetMapping("/add")
	public String addPage() {
		return "Add";
	}
	
	@PostMapping("/add")
	public String addEmpployee(@RequestParam String name,
			                   @RequestParam String email,
			                   @RequestParam long contact,
			                   @RequestParam String address,
			                   ModelMap map) {
		EmployeePOJO pojo = service.addEmployee(name, email, contact, address);
		
		if(pojo != null) {
			//Success
			map.addAttribute("msg","Data inserted successfully...!");
			return "Add";
		}
		else {
			//Failure
			map.addAttribute("msg","Data Not inserted...!");
			return "Add";
		}
		
	}
	
	
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@RequestParam int id,
			                     ModelMap map) {
		EmployeePOJO pojo=service.searchEmployee(id);
		
		if(pojo != null) {
			//Success
			map.addAttribute("employee",pojo);
			map.addAttribute("msg","Employee Data Found Successfully...!");
			return "Search";
		}
		else {
			//Failure
			map.addAttribute("msg","Employee Data Not Found...!");		    
			return "Search";
		}
		
	}
	
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<EmployeePOJO> employees = service.findAllEmployees();
		//Success
		if(!employees.isEmpty()) {
		map.addAttribute("employees",employees);
		return "Remove";
		}
		else {
			//Failure
			map.addAttribute("msg","No Data Present...!");
			return "Remove";
		}
	}
	
	@PostMapping("/remove")
	public String removeEmployee(@RequestParam int id, ModelMap map) {
		EmployeePOJO pojo= service.removeEmployee(id);
		List<EmployeePOJO> employees = service.findAllEmployees();
		
		
		
		if(pojo != null) {
			//Success
		map.addAttribute("msg","Data Remove Successfully...!");
		map.addAttribute("employees",employees);
		return "Remove";
		}
		else {
			//Failure
			map.addAttribute("msg","Data Not Exist...!");
			map.addAttribute("employees",employees);
			return "Remove";
			
		}
	}
	
	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		
		List<EmployeePOJO> employees=service.findAllEmployees();
		map.addAttribute("employees",employees);
		return "Update";
		
	}
	
	//Update form Controller
		@PostMapping("/update")
		public String updateForm(@RequestParam int id,
									ModelMap map) {
			EmployeePOJO pojo = service.searchEmployee(id);
			//Success
			if (pojo != null) {
				map.addAttribute("employee",pojo);
				return "Update";
			}
			//Failure
			List<EmployeePOJO> employees = service.findAllEmployees();
			map.addAttribute("employees",employees);
			map.addAttribute("msg", "Employee data not found..!");
			return "Update";
		}
		
		
		//Update student Controller
		@PostMapping("/updateEmployee")
		public String updateEmployee(@RequestParam int id,
									 @RequestParam String name,
									 @RequestParam String email,
									 @RequestParam long contact,
									 @RequestParam String address,
									 ModelMap map) {
			EmployeePOJO pojo = service.updateEmployee(id, name, email, contact, address);
			//Success
			if (pojo != null) {
				List<EmployeePOJO> employees = service.findAllEmployees();
				map.addAttribute("msg", "Data updated successfully..!");
				map.addAttribute("employees", employees);
				return "Update";
			}
			List<EmployeePOJO> employees = service.findAllEmployees();
			map.addAttribute("msg", "Data not updated..!");
			map.addAttribute("employees", employees);
			return "Update";
		}
	

}

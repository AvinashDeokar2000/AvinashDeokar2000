package com.jspiders.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.pojo.StudentPOJO;
import com.jspiders.springmvc1.service.StudentService;

@Controller
public class StudentController {
      
	@Autowired
	private StudentService service;
	
	
	// Home page Controller
	@GetMapping("/javaVideo")
	public String javaVideo() {
		return "JavaVideo";
	}
	
	// Home page Controller
		@GetMapping("/pythonVideo")
		public String pythonVideo() {
			return "PythonVideo";
		}
		
		// Home page Controller
		@GetMapping("/communicationVideo")
		public String communicationVideo() {
			return "CommunicationVideo";
		}
		
		// Home page Controller
		@GetMapping("/home")
		public String home() {
			return "Home";
		}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage() {
		return "Add";
	}
	
	
	//Add Student Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, 
			                                        @RequestParam String email,
			                                        @RequestParam long contact, 
			                                        @RequestParam String address, 
			                                        ModelMap map) {
		
		StudentPOJO pojo =service.addStudent(name, email, contact, address);
		
		//Success
		if(pojo != null) {
			
			map.addAttribute("msg","Data inserted succeccfully...!");
			return "Add";
			
		}
		//Failure
		map.addAttribute("msg","Data not inserted succeccfully...!");
		return "Add";
	}
	
	

	// Search Page Controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	
	
	//Search student Controller
		@PostMapping("/search")
        public String searchStudent(@RequestParam int id, 
        		ModelMap map) {
			
			StudentPOJO pojo=service.searchStudent(id);
			
			//Success
			if(pojo != null) {
				map.addAttribute("student",pojo);
				map.addAttribute("msg", "Student data found...!");
				return "Search";
			}
			//Failure
			map.addAttribute("msg", "Student data not found...!");
			return "Search";
		}

	// Remove Page Controller
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		//Success
		if(!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Remove";
		}
		
		map.addAttribute("msg", "No data present...!");
		return "Remove";
	}
	
	//Remove Student Controller
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id,
			ModelMap map) {
		StudentPOJO pojo = service.removeStudent(id);
		List<StudentPOJO> students= service.findAllStudents();
		
		//Success
		if(pojo != null) {
			map.addAttribute("msg", "Data removed successfully...!");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Data does not exist...!");
		map.addAttribute("students", students);
		return "Remove";
	}

	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		return "Update";
	}
	
	//Update form Controller
	@PostMapping("/update")
	public String updateForm(@RequestParam int id,
								ModelMap map) {
		StudentPOJO pojo = service.searchStudent(id);
		//Success
		if (pojo != null) {
			map.addAttribute("student",pojo);
			return "Update";
		}
		//Failure
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student data not found..!");
		return "Update";
	}
	
	//Update student Controller
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam int id,
								@RequestParam String name,
								@RequestParam String email,
								@RequestParam long contact,
								@RequestParam String address,
								ModelMap map) {
		StudentPOJO pojo = service.updateStudent(id, name, email, contact, address);
		//Success
		if (pojo != null) {
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data updated successfully..!");
			map.addAttribute("students", students);
			return "Update";
		}
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("msg", "Data not updated..!");
		map.addAttribute("students", students);
		return "Update";
	}

	

}

package com.emp_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp_system.entity.Employee;

@Controller
public class EmpController {

	@GetMapping("/")
	public String home() {
		return "index";
		
	}
	
	@GetMapping("/add_emp")
	public String addEmpForm() {
		
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) {
		
		System.out.println(e);
		
		return "add_emp";
	}
	
	
}

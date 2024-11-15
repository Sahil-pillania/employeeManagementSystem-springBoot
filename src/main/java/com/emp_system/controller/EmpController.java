package com.emp_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp_system.entity.Employee;
import com.emp_system.service.EmpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmpService service; 

	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp  = service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
		
	}
	
	@GetMapping("/add_emp")
	public String addEmpForm() {
		
		return "add_emp";
	}
	
	/*
	 * @PostMapping("/register") public String empRegister(@ModelAttribute Employee
	 * e,HttpSession session) {
	 * 
	 * 
	 * System.out.println(e); service.addEmp(e);
	 * 
	 * session.setAttribute("msg", "Employee added Successfully."); return
	 * "redirect:/"; }
	 */
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session, HttpServletRequest request, Model model) {
	    // Print the employee details to console for debugging
	    System.out.println(e);
	    // Add the employee to the service
	    service.addEmp(e);
	    // Set a success message in the session
	    session.setAttribute("msg", "Employee added Successfully.");
	    
	    // Add the context variables for Thymeleaf
	    model.addAttribute("request", request);
	    model.addAttribute("session", session);
	    model.addAttribute("servletContext", request.getServletContext());
	    
	    // Redirect to the home page
	    return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
	
		Employee e =service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
		
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session, HttpServletRequest request, Model model ) {
		
		service.addEmp(e);
	    // Set a success message in the session
	    session.setAttribute("msg", "Employee Updated Successfully.");
	    
	    // Add the context variables for Thymeleaf
	    model.addAttribute("request", request);
	    model.addAttribute("session", session);
	    model.addAttribute("servletContext", request.getServletContext());
	    // Redirect to the home page
	    return "redirect:/";
		
	}
	
	
	


	
	
}

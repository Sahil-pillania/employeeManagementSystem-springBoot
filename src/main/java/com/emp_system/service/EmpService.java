package com.emp_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_system.entity.Employee;
import com.emp_system.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
		
	}
	
	// getting all employees
	
	public List<Employee> getAllEmp() {
		
		List<Employee> allEmp = repo.findAll();
		return allEmp;
	}
	
	// finding/getting one employee details
	public Employee getEmpById(int id) {
	
		
		Optional<Employee> e =  repo.findById(id);
		if(e.isPresent()) {
			
			return  e.get();
		}
		return null;
	}
	
	// deleting the employee
	public void deleteEmp(int id) {
		
		repo.deleteById(id);
	}
	
	

}

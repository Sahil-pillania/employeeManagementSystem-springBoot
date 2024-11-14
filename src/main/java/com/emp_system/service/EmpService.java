package com.emp_system.service;

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

}

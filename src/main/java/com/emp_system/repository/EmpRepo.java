package com.emp_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp_system.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}

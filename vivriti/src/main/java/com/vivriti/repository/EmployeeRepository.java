package com.vivriti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivriti.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}

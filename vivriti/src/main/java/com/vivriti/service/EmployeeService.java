package com.vivriti.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivriti.exception.ResourceNotFoundException;
import com.vivriti.model.Employee;
import com.vivriti.repository.EmployeeRepository;

import lombok.Setter;

@Service
@Transactional
public class EmployeeService {
 
	@Autowired
	private EmployeeRepository empRepository;
	
	/*
	  * Post into H2 database
	  */
	public Employee saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	
	 /*
	  * Get List from H2 db
	  */
	public List<Employee> getEmps(){
		return empRepository.findAll();
	}
	/*
	  * Update Employee in H2 DB
	  */
	public Employee updateEmp(Employee emp) throws ResourceNotFoundException{
		Optional<Employee> emp_new = empRepository.findById(emp.getId());
		if(!emp_new.isPresent()) {
			throw new ResourceNotFoundException("Resource not found");
		}
		else {
			Employee emp1 = emp_new.get();
			emp1.setId(emp.getId());
			emp1.setFirstName(emp.getFirstName());
			emp1.setLastName(emp.getLastName());
			emp1.setMobileNumber(emp.getMobileNumber());
			emp1.setAddress(emp.getAddress());
			emp1.setDepartment(emp.getDepartment());
			empRepository.save(emp1);
			return emp1;
		}
	}
	/*
	  * Get Employee By id from H2 DB
	  */
	public Employee getEmployeeById(long id) throws ResourceNotFoundException{
			Optional<Employee> emp_new = empRepository.findById(id);
			
			if(!emp_new.isPresent()) {
				throw new ResourceNotFoundException("Resource not found");
			}
			else {
				return emp_new.get();
			}	
	}
	
	public void deleteEmployee(long id)throws ResourceNotFoundException{
		Optional<Employee> emp_new =empRepository.findById(id);
		if(!emp_new.isPresent()) {
			throw new ResourceNotFoundException("Resource Not found");
		}
		else {
			empRepository.delete(emp_new.get());
		}
	}
}

package com.vivriti.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivriti.exception.ResourceNotFoundException;
import com.vivriti.model.Employee;
import com.vivriti.service.EmployeeService;

@RestController
public class EmployeeController {

@Autowired
private EmployeeService empService;

@GetMapping("/employees")
public List<Employee> getAllEmployees(){
	return empService.getEmps();	
}

@PostMapping("/employees")
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
	return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
}

@PatchMapping("/employees/{id}")
public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id")long id) throws ResourceNotFoundException{
	emp.setId(id);
	return new ResponseEntity<Employee>(empService.updateEmp(emp),HttpStatus.CREATED);
}

@DeleteMapping("/employees/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable ("id") long id) throws ResourceNotFoundException{
	empService.deleteEmployee(id);
	return new ResponseEntity<String>("User Deleted successfully",HttpStatus.OK);
}
}

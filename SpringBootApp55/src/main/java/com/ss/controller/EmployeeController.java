package com.ss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.dao.EmployeeRepo;
import com.ss.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "Sucess";
	}
	
	@PostMapping("/employee")
	public Employee addEmp(@RequestBody Employee emp) {
		repo.save(emp);
		return emp;
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmps(){
		return repo.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmp(@PathVariable("id") int id){
		return repo.findById(id);
	}
	

	@PutMapping("/employee")
	public Employee updateEmp(@RequestBody Employee emp) {
		repo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deletEmp(@PathVariable() int id){
		Employee emp = repo.getOne(id);
		 repo.delete(emp);
		 return "Deleted";
	}
}

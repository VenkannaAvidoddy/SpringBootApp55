package com.ss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}

package com.javafsd.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafsd.departmentservice.entity.Department;
import com.javafsd.departmentservice.exception.DepartmentNotFound;
import com.javafsd.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;	//Fill Injection
	
	
	
	public Department saveDepartment(Department department) {
		//Department Responce
		return departmentrepository.save(department);
	}
	
	public Department findByDepartmentid(Long departmentid){
		Department department =  departmentrepository.findByDepartmentid(departmentid);
		if(department ==null) {
			throw new DepartmentNotFound("Department dosent exist for this");
		}
		return department;
	}
		
	}
	

	
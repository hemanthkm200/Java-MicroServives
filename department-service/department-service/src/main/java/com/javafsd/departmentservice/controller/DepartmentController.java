package com.javafsd.departmentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.departmentservice.entity.Department;
import com.javafsd.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentservice;
	
	private final Logger LOGGER = LoggerFactory.getLogger(Department.class);
	//This For Post Mapping
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		LOGGER.info("Inside Save Department Method");
		return departmentservice.saveDepartment(department);
	}
	
	//Get Mapping
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long departmentid) {
		LOGGER.info("Inside Get Department Method");
		return departmentservice.findByDepartmentid(departmentid);
		
	}
}

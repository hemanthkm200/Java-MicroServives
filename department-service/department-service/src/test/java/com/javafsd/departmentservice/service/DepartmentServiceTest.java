package com.javafsd.departmentservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javafsd.departmentservice.entity.Department;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	public void whenValidDepartmentId_thenDepartmentShouldFound() {
		Long departmentId = 1L;
		Department found =  departmentService.findByDepartmentid(departmentId);
		//Compare Expected Result With Actual Result
		assertEquals(departmentId, found.getDepartmentid());
		
	}
	

}

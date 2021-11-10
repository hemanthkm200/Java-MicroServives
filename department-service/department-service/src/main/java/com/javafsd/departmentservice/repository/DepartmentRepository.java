package com.javafsd.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafsd.departmentservice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	public Department findByDepartmentid(Long departmentid);

}

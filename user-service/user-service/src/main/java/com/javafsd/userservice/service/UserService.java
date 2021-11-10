package com.javafsd.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.javafsd.userservice.entity.User;
import com.javafsd.userservice.exception.UserNotFoundException;
import com.javafsd.userservice.repository.UserRepository;
import com.javafsd.userservice.vo.Department;
import com.javafsd.userservice.vo.ResponceTemplate;

import io.github.resilience4j.retry.annotation.Retry;

/*
 * ***********CLASSES USED**************************
 * Controller => UserController
 * Entity => User
 * Exception => ErrorMessage, RestResponceEntityExceptionHandler, UserNotFoundException
 * Repository => UserRespository
 * Service => UserService
 * VO => Department,ResponceTemplate
 */


@Service
public class UserService {

	public static final String USERSERVICE = "userService";
	Long USER_ID;
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private RestTemplate resttemplate;
	//Save it to the database
	public User saveUser (User user) {
		return userrepository.save(user);
	}


	@Retry(name = USERSERVICE, fallbackMethod = "fallback_getUserWithDepartment")
	public ResponceTemplate getUserWithDepartment(Long userId) {
		ResponceTemplate responcetemplate = new ResponceTemplate();		
		User userResponse = userrepository.findByUserId(userId);
		USER_ID=userId;
		//Calling Department Entity
		Department departmentResponse = resttemplate.getForObject(
				"http://DEPARTMENT-SERVICE/departments/"
						+userResponse.getDepartmentId(),Department.class);
		if(userResponse == null || departmentResponse ==null) {
			throw new UserNotFoundException("User Not Available");
		}
		responcetemplate.setUser(userResponse);
		responcetemplate.setDepartment(departmentResponse);
		return responcetemplate;
	}

	public ResponceTemplate fallback_getUserWithDepartment(Exception exception){
		ResponceTemplate responcetemplate = new ResponceTemplate();		
		User userResponse = userrepository.findByUserId(USER_ID);
		if(userResponse == null) {
			throw new UserNotFoundException("User Not Available");
		}

		Department department = new Department();
		department.setDepartmentName("HR");
		department.setDepartmentCode("H");
		department.setDepartmentAddress("Pune");
		responcetemplate.setUser(userResponse);
		responcetemplate.setDepartment(department);
		return responcetemplate;
	}



}

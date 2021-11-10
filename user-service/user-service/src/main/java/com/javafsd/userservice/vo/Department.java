package com.javafsd.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Value Object class is used to Interact with Modules

@Data
@AllArgsConstructor
@NoArgsConstructor	
public class Department {
	//Place Holders
	private long departmentid;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}

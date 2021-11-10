package com.javafsd.userservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * This Class Represents Database Entities
 * --In This Class We Are Using H2 Database
 *      --(H2 Inbuilt Database)--
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)// This is For Generating Auto UserId
	//Entities For The Table
	private Long userId;
	@NotNull
	private String firstName;
	private String lastName;
	private String email;
	private Long departmentId;

}

package com.javafsd.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafsd.userservice.entity.User;


/*
 * in this class all database operations will be managed by
 * JpaRepository (All CRUD Operations)
 */
//This is to Store Data With H2 Database
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUserId(Long userId);



}

/**
 * 
 */
package com.kodehiveminiproject.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodehiveminiproject.model.User;

/**
 * @author ryo rangga sumagusta
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}

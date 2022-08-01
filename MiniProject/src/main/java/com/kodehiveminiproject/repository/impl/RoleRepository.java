/**
 * 
 */
package com.kodehiveminiproject.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodehiveminiproject.model.Role;
import com.kodehiveminiproject.model.User;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}

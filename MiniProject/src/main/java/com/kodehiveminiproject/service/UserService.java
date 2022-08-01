/**
 * 
 */
package com.kodehiveminiproject.service;

import java.util.List;

import com.kodehiveminiproject.model.Role;
import com.kodehiveminiproject.model.User;

/**
 * @author ryo rangga sumagusta
 * 
 * @since Jul 28, 2022
 */
public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUser();
}

package org.sid.demo.service;

import org.sid.demo.entities.AppRole;
import org.sid.demo.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser u);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username,String role);
}

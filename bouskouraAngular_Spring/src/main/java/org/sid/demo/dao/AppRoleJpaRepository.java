package org.sid.demo.dao;


import org.sid.demo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleJpaRepository extends JpaRepository<AppRole, Integer>{
	public AppRole findByRole(String role) ;
}

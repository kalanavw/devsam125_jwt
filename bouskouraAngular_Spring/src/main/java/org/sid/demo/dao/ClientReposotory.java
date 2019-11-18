package org.sid.demo.dao;

import org.sid.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposotory extends JpaRepository<Client, Integer>  {

}

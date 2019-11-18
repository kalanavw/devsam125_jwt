package org.sid.demo;

import java.util.Collection;

import org.sid.demo.dao.ProduitReposotory;
import org.sid.demo.entities.AppRole;
import org.sid.demo.entities.AppUser;
import org.sid.demo.entities.Produit;
import org.sid.demo.service.AccountService;
import org.sid.demo.service.ClientImp;
import org.sid.demo.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan( basePackages = { "org.sid.demo.controller","org.sid.demo.service","org.sid.demo.security" }) 
	public class BouskouraAngularSpringApplication implements CommandLineRunner  {
	public static void main(String[] args) {
		SpringApplication.run(BouskouraAngularSpringApplication.class, args);
	}
	
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
ProduitReposotory prodRep;
	@Autowired
	AccountService AccountService;
	@Override
	public void run(String... args) throws Exception {
	/*	AccountService.saveUser(new AppUser( "Ahmed", "1234", null));
		AccountService.saveRole(new AppRole("ADMIN"));
		AccountService.addRoleToUser("Ahmed", "ADMIN");
		*/
		/*for (int i=0;i<10;i++)
		{
			Produit  p = new Produit();	
		
			p.setImage(i+".jpg");
			p.setPrix(1000+i);
			p.setRef("ref"+i);
			p.setTitre("produit "+i);
			prodRep.save(p);
		}*/

		
		
		
	}
	
	
	
	  

}

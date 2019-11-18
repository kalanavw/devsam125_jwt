package org.sid.demo.controller;

import org.sid.demo.entities.AppUser;
import org.sid.demo.entities.Client;
import org.sid.demo.service.AccountService;
import org.sid.demo.web.FormUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControlle {
	@Autowired
	AccountService acoutserve;
	
	@RequestMapping(path = "/incrire",method = RequestMethod.POST)
	public AppUser inscription(@RequestBody FormUser userf) {
		if (!userf.getPassword().equals(userf.getRePass()))
		{
			
			return null;
			
		}
		else 
		{
			AppUser apU=	acoutserve.findUserByUsername(userf.getNom());
			
			if(apU==null)
			{
				return null;
			}
			else
			{
				
				AppUser apu= new AppUser();
		
				apu.setPassword(userf.getPassword());
				apu.setUsername(userf.getNom());
				acoutserve.saveUser(apu);
				return apu;
			}
		
		}
	
		
	}

}

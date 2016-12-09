package com.tutorial.sample.service;

import com.tutorial.sample.dao.Dao;
import com.tutorial.sample.entity.Entity;

public class Service {

	private Dao dao = null;
	
	public Service(Dao dao){
		this.dao = dao;
	}
	
	public String getKey(String keyId){
		Entity entity = dao.findById(keyId);
		return entity.getFirstName()+""+entity.getLastName(); 
	}
	
}

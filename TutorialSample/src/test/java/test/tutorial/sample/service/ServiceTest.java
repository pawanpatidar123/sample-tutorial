package test.tutorial.sample.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.tutorial.sample.dao.Dao;
import com.tutorial.sample.entity.Entity;
import com.tutorial.sample.service.Service;

public class ServiceTest {

	@Mock
	private static Dao dao;
	
	private static Service service ;
	
	@BeforeClass
	public static void  getSetup(){
		dao = Mockito.mock(Dao.class);
		service = new Service(dao);
	}
	
	
	@Test
	public void testGetKey(){
		String keyId = "123";
		Mockito.when(dao.findById(keyId)).thenReturn(createTestEntity());
		Assert.assertEquals("AmitSharma",service.getKey(keyId));
		Mockito.verify(dao).findById(keyId);
	}
	
	private Entity createTestEntity(){
		Entity entity = new Entity();
		entity.setFirstName("Amit");
		entity.setLastName("Sharma");
		return entity;
	}
	
}

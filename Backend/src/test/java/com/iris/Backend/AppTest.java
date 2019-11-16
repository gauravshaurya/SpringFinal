package com.iris.Backend;

import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;  //Static import

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.config.DBConfig;

public class AppTest {

	private static UserDao userDaoObj;
	
	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//Passing the object of Configuration to the Spring container and refershing it
   	 	//context.register(DBConfig.class);
   	 	//context.refresh();
   	 	
   	 	//Asking the object of PRoductDao from the spring container so that we can 
   	 	//test its methods.
   	 	userDaoObj=context.getBean(UserDao.class,"userDao");
   	 	out.println("I m in init - end");
	}
	
	@Test
	@Ignore
	public void registerUserTest(){
		User p=new User();
		p.setFirstName("Gourav");
		p.setLastName("Kumar");
		
		boolean r=userDaoObj.registerUser(p);
		assertTrue("Problem in Registering user", r);
	}
	
	@Test
	@Ignore
	public void getProductByIdTest(){
		User pObj=userDaoObj.getUserById(1);
		assertNotNull("Product with given id doesnt exist", pObj);
	}
	/*
	 * @Test public void getAllProductsTest(){ List<User>
	 * uList=userDaoObj.getAllUsers(); Assert.assertNotEquals("Not User Found...",
	 * uList.size(), 0); }
	 */
	
}
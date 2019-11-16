package com.iris.main;

import com.iris.daos.UserDao;
import com.iris.daosimpl.UserDaoImpl;
import com.iris.models.User;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
  
    	User uObj=new User();
    	System.out.println( "Enter your details" );
    	System.out.println( "Email" );
    	uObj.setEmail(sc.nextLine());
    	System.out.println( "First Name" );
    	uObj.setFirstName(sc.nextLine());
    	System.out.println( "Last Name" );
    	uObj.setLastName(sc.nextLine());
    	System.out.println( "Gender" );
    	uObj.setGender(sc.nextLine());
    	System.out.println( "City" );
    	uObj.setCity(sc.nextLine());
    	System.out.println( "Role" );
    	uObj.setRole(sc.nextLine());
    	System.out.println( "Password" );
    	uObj.setPassword(sc.nextLine());
    	
    	UserDao userDao=new UserDaoImpl();
    	userDao.registerUser(uObj);
    	
    	System.out.println( "Enter userid to get details" );
		System.out.println(userDao.loginUser(sc.nextInt()));
    }
}

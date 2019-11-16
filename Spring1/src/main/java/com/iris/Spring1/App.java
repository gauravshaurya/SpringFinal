package com.iris.Spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.iris.Spring1.Engine;
import com.iris.Spring1.Vehicle;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=
    			new ClassPathXmlApplicationContext("spring.xml");
    	
    	Vehicle vehi=(Vehicle)context.getBean("vObj");
    	System.out.println(vehi);
    }
}

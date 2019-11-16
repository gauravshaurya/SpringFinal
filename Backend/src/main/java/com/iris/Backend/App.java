package com.iris.Backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DBConfig.class);
    	System.out.println( "Hello World!" );
    }
}

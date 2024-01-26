package com.mavenproject;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ijdbc;
import dao.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con=new AnnotationConfigApplicationContext(configjdbc.class);
        ijdbc jt=con.getBean(jdbc.class);
        Student s=new Student();
        s.setID(3);
        s.setName("Bhaiu");
        s.setCity("kanpur");
        int r=jt.insert(s);
        System.out.println(r);
        
        
    }
}

package com.bridgelabz.MappingDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.Controller.Laptop;
import com.bridgelabz.Controller.Student;

public class App 
{
    public static void main( String[] args )
    {
		SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		Student stud = new Student();
		stud.setRollNo(11);
		stud.setName("mohan");
		session.save(stud);
		//stud.getLaptop().add(laptop);
		//laptop.setStud(stud);
		
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setName("Dell");
		laptop.setStud(stud);
		
		Laptop laptop1 = new Laptop();
		laptop1.setLid(102);
		laptop1.setName("HP");
		laptop1.setStud(stud);
		
		
		session.save(laptop);
		session.save(laptop1);

		session.getTransaction().commit();
		session.close();
    }
}

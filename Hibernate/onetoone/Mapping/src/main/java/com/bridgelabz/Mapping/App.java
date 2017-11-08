package com.bridgelabz.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.Controller.Laptop;
import com.bridgelabz.Controller.Student;


public class App 
{
    public static void main( String[] args )
    {
    	Laptop laptop = new Laptop();
		laptop.setLid(1);
		laptop.setName("Dell");

		Student stud = new Student();
		stud.setRollNo(1);
		stud.setName("mohan");
		stud.setLaptop(laptop);

		SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		session.save(laptop);
		session.save(stud);
		session.getTransaction().commit();
    }
}

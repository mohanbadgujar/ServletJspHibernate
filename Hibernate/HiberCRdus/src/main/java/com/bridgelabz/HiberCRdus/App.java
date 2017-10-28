package com.bridgelabz.HiberCRdus;

import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bridgelabz.controller.HibernateUtil;
import com.bridgelabz.model.Employee;

public class App {
 
	private static Scanner scanner;


	public static void main(String[] args) {
		
		System.out.println("Welcome to Hibernate Crud Operation\n Please select your choice\n1)Insert\n2)Retrive\n3)Update\n4)Delete");
		scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		App me = new App();
		
		switch (choice) {
		case 1:
			System.out.println("Enter Employee name =");
			String name = scanner.next();
			System.out.println("Enter City name =");
			String city = scanner.next();
			System.out.println("Enter Salary=");
			int salary = scanner.nextInt();
			System.out.println("Enter Phone No=");
			long phone = scanner.nextLong();
		
			me.saveEmployee(name, city, salary, phone);
	
			break;
		case 2:
			me.retriveEmployee();
			break;
		case 3:
			me.updateEmployee();
			break;
		case 4:
				me.deleteEmployee();
			break;
		default:
			break;
		}

	}
	
	
	public void saveEmployee(String name, String city, int salary, long phone) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tra = null;
		try {
			
			tra = session.beginTransaction();
			Employee emp = new Employee();
			emp.setName(name);
			emp.setCity(city);
			emp.setSalary(salary);
			emp.setPhoneno(phone);
			session.save(emp);
			tra.commit();
			System.out.println("Record Inserted Succesfully");
			
		} catch (HibernateException e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	public void deleteEmployee()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tra = null;
		try {
			
			tra = session.beginTransaction();
	
			String queryString = "delete Employee where salary = :salary";
			Query query = session.createQuery(queryString);
			query.setParameter("salary", 345345);
	        int res = query.executeUpdate();
	
            System.out.println("Employee records Deleted!"+res);;
			
		} catch (HibernateException e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	public void updateEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tra = null;
		try {
			
			tra = session.beginTransaction();
	
			String queryString = "update Employee e set e.salary=? where e.phoneno=111";
			Query query = session.createQuery(queryString);
			query.setParameter(0,1234567);
	        int res = query.executeUpdate();
		
            System.out.println("Employee records updated!"+res);;
			
		} catch (HibernateException e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	
	 public void retriveEmployee()
	    {
	 
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tra = null;
	        try {
	            tra = session.beginTransaction();
	            
	            List<Employee> employees = (List<Employee>) session.createQuery("from Employee e where e.phoneno=111").list();
	            
				if (employees!=null) {
					for (Employee employee : employees) {
						System.out.println(employee.getName() + "  "
		                        + employee.getCity() + "  " + employee.getSalary()
		                        + "   " + employee.getPhoneno());
					}
				}
	         
	            tra.commit();
	 
	        } catch (HibernateException e) {
	 
	            tra.rollback();
	 
	            e.printStackTrace();
	 
	        } finally {
	 
	            session.close();
	 
	        }
	    }

}


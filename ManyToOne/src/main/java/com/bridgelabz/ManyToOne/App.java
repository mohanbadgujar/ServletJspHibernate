package com.bridgelabz.ManyToOne;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bridgelabz.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Address address = null;
		Integer empdata = null;

		App me = new App();

		while (true) {
			System.out.println(
					"Welcome to many to one mapping\nPlese enter your choice\n1)Add Address\n2)Add Employee\n3)Display\n4)Update\n5)Delete");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter Address Details");
				System.out.println("Enter street=");
				String street = sc.next();
				System.out.println("Enter city=");
				String city = sc.next();
				System.out.println("Enter state=");
				String state = sc.next();
				System.out.println("Enter zipcode=");
				String zipcode = sc.next();

				address = me.addAddress(street, city, state, zipcode);
				System.out.println("Address" + address);

				break;

			case 2:

				System.out.println("Enter Employee Details");
				System.out.println("Enter name=");
				String name = sc.next();
				System.out.println("Enter salary=");
				String salary = sc.next();

				empdata = me.addEmpData(name, salary, address);

				System.out.println("emp1" + empdata);

				break;

			case 3:
				me.DisplayEmployee();
				break;

			case 4:

				System.out.println("Enter id to which data to be updated=");
				int id = sc.nextInt();
				me.UpdateData(empdata, "50000");
				break;

			case 5:
				System.out.println("Enter id to which data to be deleted=");
				int id1 = sc.nextInt();
				me.Delete(empdata);
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}

	/* Method to add an address record in the database */
	public Address addAddress(String street, String city, String state, String pincode) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		// Integer addressID = null;
		Address address = null;

		try {
			tx = session.beginTransaction();
			address = new Address(street, city, state, pincode);
			System.out.println("Adreee" + address);
			session.save(address);

			// addressID = (Integer) session.save(address);
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return address;
	}

	/* Method to add an address record in the database */

	public Integer addEmpData(String name, String salary, Address address) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Integer employeeId = null;

		try {
			tx = session.beginTransaction();
			Employee emp = new Employee(name, salary, address);
			employeeId = (Integer) session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeId;
	}

	public void DisplayEmployee() {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("Employee Name=" + employee.getName());

				System.out.println("Employee Salary=" + employee.getSalary());

				Address address = employee.getAddress();

				System.out.println("Employee Street =" + address.getStreet());

				System.out.println("Employee City =" + address.getCity());

				System.out.println("Employee state =" + address.getState());

				System.out.println("Employee Zipcode =" + address.getZipcode());

				System.out.println("--------------------------------------------------------------------------");

			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Update employee data
	public void UpdateData(Integer empid, String salary) {

		System.out.println("salary" + salary);
		System.out.println("empid" + empid);
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Employee employee = session.get(Employee.class, empid);
			employee.setSalary(salary);
			session.update(employee);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Delete Record
	public void Delete(Integer empid) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, empid);
			session.delete(employee);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}

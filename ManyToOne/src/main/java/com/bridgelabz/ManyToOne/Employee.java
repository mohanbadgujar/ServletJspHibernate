package com.bridgelabz.ManyToOne;

public class Employee {
	
	private int id;
	private String name;
	private String salary;
	private Address address;
	
	public Employee() {
	}
	
	public Employee(String name,String salary,Address address) {
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}

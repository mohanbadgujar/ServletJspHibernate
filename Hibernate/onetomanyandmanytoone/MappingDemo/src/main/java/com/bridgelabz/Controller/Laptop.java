package com.bridgelabz.Controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Laptop")
public class Laptop {
	
	@Id
	private int lid;
	
	private String name;
	
	@ManyToOne
	private Student stud;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student getStud() {
		return stud;
	}
	
	public void setStud(Student stud) {
		this.stud = stud;
	}
}

package com.bridgelabz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Table")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String name;
	private String email;
	private String password;
	private String repassword;
	private String mobile;
	private String birth;
	private String sex;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String repassword, String mobile, String birth,
			String sex) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.mobile = mobile;
		this.birth = birth;
		this.sex = sex;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}

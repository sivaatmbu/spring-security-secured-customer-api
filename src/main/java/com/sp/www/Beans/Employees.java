package com.sp.www.Beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employees {
	@Id
	int id;
	String name;
	String password;
	public Employees() {
	}
	public Employees(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

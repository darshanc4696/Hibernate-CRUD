package com.tap.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "dept")
	private String dept;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private int salary;
	
	
	
	public Employee() {
		super();
	}

	public Employee(int id, String dept, String name, int salary) {
		super();
		this.id = id;
		this.dept = dept;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return id+","+dept+","+name+","+salary;
	}
}

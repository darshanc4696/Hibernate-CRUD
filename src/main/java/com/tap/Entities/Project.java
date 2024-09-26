package com.tap.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "emp_proj",
				joinColumns = @JoinColumn(name = "proj_id"),
				inverseJoinColumns = @JoinColumn(name = "emp_id"))
	private List<Employees> employees;
	
	public Project() {
		super();
	}

	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [" + id + "," + name + "]";
	}

}

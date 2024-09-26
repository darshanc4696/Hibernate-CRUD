package com.tap.Manager;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.Entities.Employees;
import com.tap.Entities.Project;

public class HibernateManager3 
{
	private Session session;

	public HibernateManager3()
	{
		session = new Configuration().configure().addAnnotatedClass(Employees.class)
				.addAnnotatedClass(Project.class).buildSessionFactory().openSession();
	}
	
	public void add()
	{
		Employees darshan = new Employees(1, "Darshan", "darshan@gmail.com");
		Employees indresh = new Employees(2, "Indresh", "indresh@gmail.com");
		Employees akshay = new Employees(3, "Akshay", "akshay@gmail.com");
		
		Project pr = new Project(101, "PremierPro");
		Project ae = new Project(102, "AfterEffects");
		
		ArrayList<Employees> prEmployees = new ArrayList<Employees>();
		prEmployees.add(darshan);
		prEmployees.add(indresh);
		prEmployees.add(akshay);
		pr.setEmployees(prEmployees);
		
		ArrayList<Employees> aeEmployees = new ArrayList<Employees>();
		aeEmployees.add(darshan);
		aeEmployees.add(akshay);
		ae.setEmployees(aeEmployees);
		
		session.beginTransaction();
		session.persist(darshan);
		session.persist(indresh);
		session.persist(akshay);
		
		session.persist(ae);
		session.persist(pr);
		
		session.getTransaction().commit();
		System.out.println("Successfully added");
		
	}

}

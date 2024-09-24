package com.tap.Manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.Entities.Employee;

public class HibernateManager 
{
	private Session session;
	private static final String FETCH_ALLEMPLOYEE = "from Employee e where e.salary > 30000 and e.name like 'D%' ";

	public void connect()
	{
		session = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
	}
	
	public void addEmployee(Employee e)
	{
		try {
			session.beginTransaction();
			session.persist(e);
			session.getTransaction().commit();
			System.out.println("Sucessfully added");
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
	
	public void fetchAllEmployee()
	{
		try 
		{
			Query query = session.createQuery(FETCH_ALLEMPLOYEE);
			List<Employee> employees = query.list();
			
			for(Employee employee : employees)
			{
				System.out.println(employee);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void update()
	{
		try {
//			session.beginTransaction();
//			Employee  e = session.get(Employee.class, 1);
//			System.out.println(e);
//			e.setSalary(300000);
//			session.update(e);
//			session.getTransaction().commit();
//			System.out.println("Succesfully updated");
			
//			-----OR----
			
//			Employee e = new Employee(4, "Finance", "Akshay", 30000);
//			session.beginTransaction();
//			session.merge(e);  // the old method was saveOrUpdate(e) if 
//								//			the actual data was present only the data was updated if not then the data in object 
//								//			would be inserted. the same thing is done by merge(e)
//			session.getTransaction().commit();
			
//			------OR-----
			
			String hql = "Update Employee e set e.salary=80000 where e.salary >= 85000";
			
			session.beginTransaction();
			Query query = session.createQuery(hql);
			int status = query.executeUpdate();
			System.out.println(status);
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}
	
	public void delete() 
	{
		try {
			
//			session.beginTransaction();
//			Employee e = session.get(Employee.class, 1);
//			session.delete(e);
//			session.getTransaction().commit();
			
//			-----OR----
			
			String hql = "Delete from Employee e where e.salary=30000";
			
			session.beginTransaction();
			Query query = session.createQuery(hql);
			int status = query.executeUpdate();
			System.out.println(status);
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
		
	}

}

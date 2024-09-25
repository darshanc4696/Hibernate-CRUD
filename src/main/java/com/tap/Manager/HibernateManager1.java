package com.tap.Manager;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.Entities.Customer;
import com.tap.Entities.CustomerDetails;


//-------------OneToOne Mapping-------------------------------------------------------
public class HibernateManager1 
{
	private Session session;

	public HibernateManager1()
	{
		session = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class)
		.buildSessionFactory().openSession();
	}
	
	public void addCustomer(Customer c)
	{
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();
		System.out.println("Successfully Added");
	}
	
	public void displayData()
	{
		
//		---------from customer - unidirectional------------
//		Customer customer = session.get(Customer.class, 1);
//		System.out.println(customer);
		
//		---------from customer details - bidirectinal---------
		CustomerDetails cd = session.get(CustomerDetails.class, 501);
		Customer c = cd.getCustomer();
		System.out.println(cd);
		System.out.println(c);
	
	}

}

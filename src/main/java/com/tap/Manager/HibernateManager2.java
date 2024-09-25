package com.tap.Manager;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.Entities.Customer;
import com.tap.Entities.CustomerDetails;
import com.tap.Entities.Orders;


//-----------------OneToMany or ManyToOne----------------
public class HibernateManager2 
{
	private Session session;

	public HibernateManager2()
	{
		session = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class)
				.addAnnotatedClass(Orders.class).buildSessionFactory().openSession();
	}
	
	public void addOrders()
	{
		Orders o1 = new Orders(703,"Pizza",300);
		Orders o2 = new Orders(704,"Chapathi",70);
		
//		---------if we want the existing customer-----------
//		Customer c = session.get(Customer.class, 1);
		
//		----------if new Customer sign in and orders freshly---------
		CustomerDetails cd = new CustomerDetails(502, "indresh@gmail.com", "456434573", "Mysore");
		Customer customer = new Customer(2, "Indresh", cd);
		
		
		o1.setCustomer(customer);
		o2.setCustomer(customer);
		
		session.beginTransaction();
		session.persist(o1);
		session.persist(o2);
		session.getTransaction().commit();
		System.out.println("Successfully Added");
	}
	
	public void deleteOrders()
	{
		session.beginTransaction();
		Orders order = session.get(Orders.class, 702);
		session.delete(order);
		System.out.println("Sucessfully deleted");
		session.getTransaction().commit();
	}

}

package com.tap.Main;

import com.tap.Manager.HibernateManager1;

public class OneToOneMapping {

	public static void main(String[] args) 
	{
//		CustomerDetails cd = new CustomerDetails(501, "darshanc4696@gmail.com", "12345678", "Bangalore");
//		Customer customer = new Customer(1, "Darshan", cd);
		
		HibernateManager1 hm = new HibernateManager1();
//		hm.addCustomer(customer);
		hm.displayData();
	}

}

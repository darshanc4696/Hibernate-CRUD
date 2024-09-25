package com.tap.Main;

import com.tap.Manager.HibernateManager2;

public class OneToMany 
{

	public static void main(String[] args) 
	{
		HibernateManager2 hm2 = new HibernateManager2();
		hm2.deleteOrders();
	}

}

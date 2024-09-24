package com.tap.Main;

import com.tap.Manager.HibernateManager;

public class App 
{

	public static void main(String[] args) 
	{
//		changes according to operation is done here
		HibernateManager hm = new HibernateManager();
		hm.connect();
		
		hm.delete();	

	}

}

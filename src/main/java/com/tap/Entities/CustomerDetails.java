package com.tap.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customerdetails")
public class CustomerDetails 
{
	@Id
	@Column(name = "cid")
	private int cid;
	
	@Column(name="email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@OneToOne(mappedBy = "customerdetails", cascade = CascadeType.ALL)
	private Customer customer;

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(int cid, String email, String phoneNumber, String address) {
		super();
		this.cid = cid;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerDetails [" + cid + "," + email + "," + phoneNumber + ","
				+ address + "]";
	}


}

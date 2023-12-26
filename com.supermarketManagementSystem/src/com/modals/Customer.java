package com.modals;

public class Customer implements Comparable<Customer>{

	private String cust_id;
	
	public Customer(String cust_id) {
		super();
		this.cust_id = cust_id;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + "]";
	}

	@Override
	public int compareTo(Customer o) {
		
		return this.cust_id.compareTo(o.cust_id);
	}
	
}

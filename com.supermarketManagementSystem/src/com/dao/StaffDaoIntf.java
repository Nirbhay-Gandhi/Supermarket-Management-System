package com.dao;

import com.modals.Bill;
import com.modals.Cart;
import com.modals.Product;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public interface StaffDaoIntf {

	public Set<Product> viewProducts();
	public void addProduct(Product p, String staffId);
	public Product getProduct(String pname);
	public Product removeProduct(String pname, String staffId);
	
	public Map<String,Integer> getInventory(); //eg: { [kitkat -> 90], [bisleri -> 100] }
	
	public Bill processBill(String billId,String staffId, LocalDateTime ldt, Cart c, double total);
	public void updateCustomerBillInfo(String cust_id, String bill_d);
	
	public boolean updateInventoryIfValid(String productName, int prdQty);
}

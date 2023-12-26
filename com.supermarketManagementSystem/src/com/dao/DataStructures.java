package com.dao;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.modals.Bill;
import com.modals.LocalStaff;
import com.modals.Product;

public class DataStructures {
	
	Set<Product> productInventory;
	
	/**< 
	 *   P101 -> | <Add - {Coconutoil, bournvita, horlicks, bisleri, bisleri}>  | 
	 * 			 | <Update - {horlicks, bisleri}>  |
	 *           | <Delete - {kitkat, perfume, kitkat}>  |,
	 *           
	 *   P102 -> | <Add, Coconutoil>  | 
	 * 			 | <Remove, Britania> |        
	 *  >
	 * */
	Map<String, Map<String,List<String>>>  inventoryOpration; 
	
	Map<String, Integer> productQuantity;
	
	Set<Bill> bills;
	
	Map<String, Set<String>> customerBillInfo; //<Customer_mobNumber, [bill_id1, bill_id2, ..]>
	
	Set<LocalStaff> staffInfo;
	
	public DataStructures() {
		
		productInventory = new LinkedHashSet<>(); //since we want to preserve the sequence
		inventoryOpration = new LinkedHashMap<>(); //since we want to preserve the sequence
		productQuantity = new TreeMap<>(); 
		bills = new TreeSet<>();
		customerBillInfo = new TreeMap<>();
		staffInfo = new TreeSet<>();
		
	}

	/*purpose of creating getters is, currently we have not specified any access specifier. so, all the elements
	 * are under the default access modifier(i.e can only be accessed by the class of same package)*/
	public Set<Product> getProductInventory() {
		return productInventory;
	}
	public int getProductInventorySize() {
		return productInventory.size();
	}

	public Map<String, Map<String, List<String>>> getInventoryOpration() {
		return inventoryOpration;
	}
	public int getInventoryOprationSize() {
		return inventoryOpration.size();
	}

	public Map<String, Integer> getProductQuantity() {
		return productQuantity;
	}
	public int getProductQuantitySize() {
		return productQuantity.size();
	}

	public Set<Bill> getBills() {
		return bills;
	}
	public int getBillsSize() {
		return bills.size();
	}

	public Map<String, Set<String>> getCustomerBillInfo() {
		return customerBillInfo;
	}
	public int getCustomerBillInfoSize() {
		return customerBillInfo.size();
	}

	public Set<LocalStaff> getStaffInfo() {
		return staffInfo;
	}
	public int getStaffInfoSize() {
		return staffInfo.size();
	}
	
}

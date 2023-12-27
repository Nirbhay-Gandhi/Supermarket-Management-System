package com.modals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dao.StaffDaoImpl;

/** Cart kaa Ds already defiened hai iss class me, to usko dao layer me call karke koi fayda nai
 * directly use it in business layer*/

public class Cart {

	private Map<String, Integer> cart;
	private List<String> cartLogs;
	private double total;
	
	public Cart() {
		cart = new LinkedHashMap<>();
		cartLogs = new ArrayList<>();
		total = 0.0;
	}
	
	
	public void add(String prdName, int prdQnty) {
	if(cart.containsKey(prdName)) {
			int prevQty = cart.get(prdName);
				
			prdQnty = (prdQnty == 0) ? 1 : prdQnty;
				
			int currentQty = prevQty+prdQnty;
			cart.put(prdName, currentQty);
			String log = prdName + " Quantity updated from " + String.valueOf(prevQty) + " to " + String.valueOf(currentQty);
			cartLogs.add(log);
		} 
	}
	
	public double calculateTotal() {
		List<Double> priceOfQty = new ArrayList<>();
		double total = 0.0;
		//List<Integer> qty = new ArrayList<>(cart.values());
		
		Set<Map.Entry<String, Integer>> set = cart.entrySet();
		Iterator<Map.Entry<String, Integer>> itr = set.iterator();
		
		while(itr.hasNext()) {
			Map.Entry<String, Integer> entry = itr.next();
			String prdName = entry.getKey();
			Integer prdQty = entry.getValue();
			
			StaffDaoImpl sd = new StaffDaoImpl();
			double pricePerProduct = sd.getProduct(prdName).getPricePerProduct();
			
			double tempTotal = pricePerProduct * prdQty;
			priceOfQty.add(tempTotal);
		}
		
		for(Double element : priceOfQty) {
			total += element;
		}
		
		return total;
	}
	
//	public void add(String prdName) {
//		
//		if(cart.containsKey(prdName)) {
//			int prevQty = cart.get(prdName);
//			int currentQty = prevQty+1;
//			cart.put(prdName, currentQty);
//			String log = prdName + " Quantity updated from " + String.valueOf(prevQty) + " to " + String.valueOf(currentQty);
//			cartLogs.add(log);
//		}else {
//			cart.put(prdName, 1);
//			String log = prdName + " added ";
//			cartLogs.add(log);
//		}
//	}
	
	public Map<String, Integer> getCart(){
		return cart;
	}
	
	public List<String> getCartLogs(){
		return cartLogs;
	}


	@Override
	public String toString() {
		return "Cart [cart=" + cart + ", cartLogs=" + cartLogs + "]";
	}
	
//	public int totalBill() {
//		return 0;
//	}
	
}

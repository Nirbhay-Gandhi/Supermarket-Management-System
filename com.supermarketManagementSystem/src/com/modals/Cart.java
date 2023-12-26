package com.modals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Cart kaa Ds already defiened hai iss class me, to usko dao layer me call karke koi fayda nai
 * directly use it in business layer*/

public class Cart {

	Map<String, Integer> cart;
	List<String> cartLogs;
	
	public Cart() {
		cart = new LinkedHashMap<>();
		cartLogs = new ArrayList<>();
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

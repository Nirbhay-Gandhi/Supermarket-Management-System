package com.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.modals.Bill;
import com.modals.Cart;
import com.modals.Product;

public class StaffDaoImpl implements StaffDaoIntf{
	
	DataStructures ds;
	
	public StaffDaoImpl() {
		ds = new DataStructures();
	}
	
    public void updateLog(Map<String,Map<String,List<String>>> inventoryOpration, String prd, String oprn, String stfid)
    {
        /**task: P101 is adding a product "CocaCola". update the product in the Add list*/
        String inputStaff = stfid;
        //1. get the add list of P101 if its present
        Map<String, List<String>> staffOprnsList = inventoryOpration.get(inputStaff);
        
        if(staffOprnsList != null)
        {
            //update the product in the Add list
            List<String> OprnList = staffOprnsList.get(oprn);

            //if 'add' key is not present, Add the "add" key
            if(OprnList != null){
                OprnList.add(prd);
            }
            else{
                System.out.println("opern not present");
                //now proceed right to left: 1. create and append the list
                List<String> operatedProduct = new ArrayList<>();
                operatedProduct.add(prd); System.out.println("small list: "+operatedProduct);

                //2. associate that list with some operation
                Map<String, List<String>> operationMap = new LinkedHashMap<>(); //we want order of keys: "add","delete","update" 
                System.out.println(operationMap.put(oprn, operatedProduct)); 
                operationMap.put(oprn, operatedProduct);

                //3. association with the staff id
                var getObj = inventoryOpration.get(stfid);
                System.out.println("3. "+getObj.getClass().getSimpleName() + getObj);
                staffOprnsList.put(oprn, operatedProduct);
            }
        }
        else
        {
            //have to add staff as well
            //now proceed right to left: 1. create and append the list
            List<String> addedProduct = new ArrayList<>();
            addedProduct.add(prd);

            //2. associate that list with some operation
            Map<String, List<String>> tmap = new LinkedHashMap<>(); //we want order of keys: "add","delete","update" 
            tmap.put(oprn, addedProduct);

            //3. association with the staff id
            inventoryOpration.put(inputStaff, tmap);
        }

    }
	
    public void updateQuantityAddOnly(Map<String, Integer> productQuantity, String product)
    {
    	//currenty the function is only for descreate product (i.e countable products)
    	/*to modify it for continious product, we need to modify the product class and add product type
    	 * (i.e descreate/ continious). then based on that the product quantity is specified. if descrete: then in numbers
    	 * if continious then kg/l*/
    	
    	int prevQty = 0, updatedQty = 1;
    	if(productQuantity.containsKey(product)) {
    		prevQty = productQuantity.get(product);
    		updatedQty = prevQty + 1;
    	}
    	productQuantity.put(product, updatedQty);
    }
   
	@Override
	public void addProduct(Product p, String staffId) {
		
		if(!ds.productInventory.contains(p)) 
		{
			//adding a fresh product
			ds.productInventory.add(p);	
		}
		
		//update the quantity
		updateQuantityAddOnly(ds.productQuantity, p.getProduct_name());
		
		//update the inventory operation log
		updateLog(ds.inventoryOpration, p.getProduct_name(), "Add", staffId);
	}

	@Override
	public Product getProduct(String pname) {
		// TODO Auto-generated method stub
		if(ds.productInventory.contains(pname)) {
			Iterator<Product> itr = ds.productInventory.iterator();
			
			while(itr.hasNext()) {
				Product tempProduct = itr.next();
				if(tempProduct.getProduct_name().equals(pname)) {
					return tempProduct;
				}
			}
		}
		return null;
	}

	@Override
	public Product removeProduct(String pname, String staffId) {
		//remove from productInventory and productQuantity
		
		//removing from productInventory
		Product returnProduct = null;
		Iterator<Product> itr = ds.productInventory.iterator();
		while(itr.hasNext()) {
			Product tempProduct = itr.next();
			
			if(tempProduct.getProduct_name().equals(pname)) {
				returnProduct = tempProduct;
				//remove the product from the list
				itr.remove();	
				//update the inventory operation log
				updateLog(ds.inventoryOpration, pname, "Delete", staffId);
				break;
			}
		}
		
		//removing the entry from productQuantity Map 
		Set<Map.Entry<String, Integer>> qntys = ds.productQuantity.entrySet();
		Iterator<Map.Entry<String, Integer>> esitr = qntys.iterator();
		while(esitr.hasNext()) {
			
			Map.Entry<String, Integer> entry = esitr.next();
			
			if(entry.getKey().equals(pname)) {
				itr.remove();
				break;
			}
		}
		
		return returnProduct;
	}

	@Override
	public Map<String, Integer> getInventory() {
		return ds.productQuantity;
	}

	@Override
	public Bill genrateBill(String bill_id, LocalDateTime ldt, String staffId, Cart c) {
		/* Creating LocalDateTime with the current date and time
           LocalDateTime now = LocalDateTime.now();
           
           Creating LocalDateTime with specific values
           LocalDateTime specificDateTime = LocalDateTime.of(2022, 12, 31, 23, 59, 59);
		 */
		Bill b = new Bill(bill_id, staffId, ldt, c);
		
		//update the bills<> collection
		ds.bills.add(b);
		
		return null;
	}

	public void updateCustomerBillInfo(String cust_id, String bill_d) {
		
		if(ds.customerBillInfo.containsKey(cust_id)) {
			Set<String> bills = ds.customerBillInfo.get(cust_id);
			bills.add(bill_d);
		}else {
			Set<String> newBill = new TreeSet<>();
			newBill.add(bill_d);
			
			ds.customerBillInfo.put(cust_id, newBill);
		}
	}

	public Set<Product> viewProducts() {
		return ds.productInventory;
	}

	public boolean updateInventoryIfValid(String productName, int prdQty)
	{
		boolean ans = false;
		Map<String, Integer> inventory = ds.productQuantity;
		Set<Map.Entry<String, Integer>> inventorySet = inventory.entrySet();
		
		Iterator<Map.Entry<String, Integer>> ivntryStItr = inventorySet.iterator();
		while(ivntryStItr.hasNext()) 
		{
			Map.Entry<String, Integer> entry = ivntryStItr.next();
			if(entry.getKey().equals(productName))
			{
				int currentQuantity = entry.getValue();
				if(currentQuantity >= prdQty) {
					ans = true;
					//updateInventory
					int updatedQty = currentQuantity - prdQty;
					entry.setValue(updatedQty);
				}
			}
		}
		return ans;
	}
	
}

package com.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.dao.OwnerDaoImpl;
import com.dao.OwnerDaoIntf;
import com.dao.StaffDaoImpl;
import com.dao.StaffDaoIntf;
import com.modals.Cart;
import com.modals.LocalStaff;
import com.modals.Product;

public class BusinessLayer {
	
	private List<String> operationLog;
	
	private StaffDaoIntf staffDaoImplementation;
	private OwnerDaoIntf ownerDaoImplementation;
	
	public BusinessLayer() {
		staffDaoImplementation = new StaffDaoImpl();
		ownerDaoImplementation = new OwnerDaoImpl();
		operationLog = new ArrayList<>();
	}
	
	public void AddEmployee(String stfName) {
		String staffId = HelperFunctions.generateStaffId();
		LocalStaff stf = new LocalStaff(staffId, stfName);
		ownerDaoImplementation.addStaff(stf);
		operationLog.add("New staff added - "+stfName);
	}

	public void viewAllEmployees() {
		//displaying the elements of Set<LocalStaff>
		Set<LocalStaff> allStf = ownerDaoImplementation.viewStaffs();
		if(!allStf.isEmpty())
		{
			Iterator<LocalStaff> itr = allStf.iterator();
			while(itr.hasNext()) {
				LocalStaff ls = itr.next();
				System.out.println(ls.getStaffId() + " : " + ls.getName());
			}
		}
		else
		{
			System.out.println("No Employees in the Company");
		}
		operationLog.add("Called viewAllEmployees() function");
	}
	
	public void viewEmployeeWithId(String sid) {
		operationLog.add("Called viewEmployeeWithID() function");
		LocalStaff stf = ownerDaoImplementation.viewStaff(sid);
		//displaying the employee
		if(stf != null)
		{
			System.out.println("Emp ID: "+stf.getStaffId()+" EmpName: "+stf.getName());
			operationLog.add("Show successful");
		}
		else
		{
			System.out.println("Employee Not found!!");
			operationLog.add("No output");
		}
	}

	public void removeEmployee(String sid) {
		operationLog.add("Called removeEmployee() function");
		LocalStaff stf = ownerDaoImplementation.removeStaff(sid);
		//displaying the employee
		if(stf != null)
		{
			System.out.println("Emp ID: "+stf.getStaffId()+" EmpName: "+stf.getName());
			operationLog.add("Employee "+stf.getStaffId()+" removed");
		}
		else
		{
			System.out.println("Employee Not found!!");
			operationLog.add("Employee Not found");
		}
	}
	
	public void employeeOperationLogs() {
		operationLog.add("called employeeOperationLogs()");
		//Map<String, Map<String,List<String>>>
		Map<String, Map<String,List<String>>> allOpern = ownerDaoImplementation.viewAllStaffOperations();
		System.out.println(allOpern);
	}
	
	public void perticularEmployeeOperationLogs(String StaffId) {
		operationLog.add("called perticularEmployeeOperationLogs()");
		 Map<String,List<String>> empOpern = ownerDaoImplementation.viewStaffOperation(StaffId);
		 System.out.println(empOpern);
	}
	
	public void viewEmployeesWrtOperation(String operation) {
		operationLog.add("called viewEmployeesWrtOperation()");
		Set<String> perticularOpernEmps = ownerDaoImplementation.viewStaffsWrtOperation(operation);
		System.out.println(perticularOpernEmps);
	}
	
	public void addProductToInventory(String staffId,String pname, String brand, double price) {
		operationLog.add("called addProduct()");
		String prdId = HelperFunctions.generateProductId();
		/* Creating LocalDateTime with the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        Creating LocalDateTime with specific values
        LocalDateTime specificDateTime = LocalDateTime.of(2022, 12, 31, 23, 59, 59);
		 */
		LocalDate expdt = LocalDate.of(2023, 12, 31);
		Product prd = new Product(prdId, pname, brand, expdt, price);
		staffDaoImplementation.addProduct(prd, staffId);
	}
	
	public void viewProduct(String pname) {
		operationLog.add("called viewProduct()");
		Product p = staffDaoImplementation.getProduct(pname);
		System.out.println(p);
	}
	
	public void deleteProduct(String pname, String staffId) { 
		//no need to put staffname in params, we will get it from main layer, that we will capture in the data member of this class
		operationLog.add("Called removeProduct() function");
		Product p = staffDaoImplementation.removeProduct(pname, staffId);
		
		//displaying the product
		if(p != null)
		{
			System.out.println(p);
			operationLog.add("Product "+p.getProduct_name()+" removed");
		}
		else
		{
			System.out.println("Product Not found!!");
			operationLog.add("Product Not found");
		}
	}
	
	public void showInventory() {
		operationLog.add("called showInventory()");
		Map<String, Integer> inventory = staffDaoImplementation.getInventory();
		System.out.println(inventory);
	}
	
	public void viewProducts() {
		operationLog.add("called viewProducts()");
		Set<Product> prdSet = staffDaoImplementation.viewProducts();
		System.out.println(prdSet);
	}
	
	public void generateBill() {
		int controlFlow = 1;
		
		Cart c = new Cart();
		
		System.out.println("---------Enter products---------");
		while(controlFlow != 0)
		{
			System.out.println("_ _: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			String[] prdQty = new String[2];
			prdQty = input.split(" ");
			
			String product = prdQty[0];
			int qnty = (prdQty[1] == null) ? Integer.parseInt("0") : Integer.parseInt(prdQty[1]);
			
			if(staffDaoImplementation.updateInventoryIfValid(product, qnty)){
				c.add(product, qnty);
			}
		}
	}
}

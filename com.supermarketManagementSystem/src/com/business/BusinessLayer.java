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
import com.modals.Bill;
import com.modals.Cart;
import com.modals.LocalStaff;
import com.modals.Product;

public class BusinessLayer {
	
	private List<String> operationLog;
	private String staffId;
	
	private StaffDaoIntf staffDaoImplementation;
	private OwnerDaoIntf ownerDaoImplementation;
	private HelperFunctions hf;
	
	public BusinessLayer(String staffId) {
		staffDaoImplementation = new StaffDaoImpl();
		ownerDaoImplementation = new OwnerDaoImpl();
		operationLog = new ArrayList<>();
		hf = new HelperFunctions();
		this.staffId = staffId;
	}
	
	public void AddEmployee(String stfName) {
		String staffId = hf.generateStaffId();
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
	
	public void addProductToInventory(String pname, String brand, double price) {
		operationLog.add("called addProduct()");
		String prdId = hf.generateProductId();
		/* Creating LocalDateTime with the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        Creating LocalDateTime with specific values
        LocalDateTime specificDateTime = LocalDateTime.of(2022, 12, 31, 23, 59, 59);
		 */
		LocalDate expdt = LocalDate.of(2023, 12, 31);
		Product prd = new Product(prdId, pname, brand, expdt, price);
		staffDaoImplementation.addProduct(prd, this.staffId);
		System.out.println("Product added from business layer");
	}
	
	public void viewProduct(String pname) {
		operationLog.add("called viewProduct()");
		Product p = staffDaoImplementation.getProduct(pname);
		System.out.println(p);
	}
	
	public void deleteProduct(String pname) { 
		//no need to put staffname in params, we will get it from main layer, that we will capture in the data member of this class
		operationLog.add("Called removeProduct() function");
		Product p = staffDaoImplementation.removeProduct(pname, this.staffId);
		
		//displaying the product
		if(p != null)
		{
			System.out.println(p);
			System.out.println("Product "+p.getProduct_name()+" removed");
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
	
	public void viewAllCustomersBillInfo() {
		Map<String, Set<String>> customerBillInfo = ownerDaoImplementation.getCustomersBillInfo();
		System.out.println(customerBillInfo);
	}
	
	public void viewPerticularCustomerBillInfo(String custMob) {
		Set<String> billInfo = ownerDaoImplementation.getPerticularCustomersBillInfo(custMob);
		System.out.println(billInfo);
	}
	
	public void generateBill(String customerMob) {
		int controlFlow = 1;
		String billId = hf.generateBillId();
		
				
		Cart c = new Cart();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------Enter products---------");
		while(controlFlow != 0)
		{
			System.out.print("_ _: ");
			
			String input = sc.nextLine();
			String[] prdQty = new String[2];
			prdQty = input.split(" ");
			
			String product = prdQty[0];
			int qnty = (prdQty[1] == null) ? Integer.parseInt("0") : Integer.parseInt(prdQty[1]);
			
			if(staffDaoImplementation.updateInventoryIfValid(product, qnty)){
				c.add(product, qnty);
			}
			
			System.out.println("Want to continue? 0/1[n/y] ");
			controlFlow = sc.nextInt();
			
		}
		
		double total = c.calculateTotal();
		LocalDateTime ldt = LocalDateTime.of(2022, 12, 31, 23, 59, 59);
//		Bill b = new Bill(billId, "", ldt, c, total);
		Bill b = staffDaoImplementation.processBill(billId, this.staffId, ldt, c, total);
		
		staffDaoImplementation.updateCustomerBillInfo(customerMob, billId);
		
		System.out.println("-------------Bill------------");
		System.out.println(b);
		sc.close();
	}
	
}

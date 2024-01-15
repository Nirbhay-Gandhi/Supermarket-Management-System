package com.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.business.BusinessLayer;
import com.modals.LocalStaff;

public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your Id, before Proceeding ----: ");
		String loggingMemberID = sc.next(); //Admin: A$$$, Staff: P@@@
		BusinessLayer b1 = new BusinessLayer(loggingMemberID);
		
		int roleChoice = 0;
		do
		{
			System.out.print("[1] Login as Admin\n[2] Login as Staff");
			int loginChoice = sc.nextInt();
			boolean isAdmin = (loginChoice == 1) ? true : false;
			
			/*all the below operations, then we will ask whether to continue with the same role or to change the role*/
			
			int choice = 0;
			do
			{
				System.out.println("\n-----------Employee Related-----------\n");
				System.out.println("1. Add Employee");
				System.out.println("2. View All Employees");
				System.out.println("3. View Perticular Employee");
				System.out.println("4. Terminate Employee");
				
				System.out.println("\n------------Staff Operations------------\n");
				System.out.println("5. View All Staffs Operations");
				System.out.println("6. View Specific Staff's Operations");
				System.out.println("7. Specific Operation Info");
				
				System.out.println("\n-----------Customer Related-----------\n");
				System.out.println("8. View Every Bill of All Customers");
				System.out.println("9. View Specific Customer Bill History");
				
				System.out.println("\n-----------Product Related-----------\n");
				System.out.println("10. View Products");
				System.out.println("11. Add Product");
				System.out.println("12. Get Product");
				System.out.println("13. Remove Product");
				System.out.println("14. View Inventory");
				
				System.out.println("\n-----------Billing Related-----------\n");
				System.out.println("15. Generate Bill");
				System.out.println("0. Exit");
					
				choice = sc.nextInt();
					
				switch(choice)
				{
					case 1:
						if(isAdmin) 
						{
							System.out.print("Enter staff Name: ");
							String stffName = "";
							stffName = sc.next();
							b1.AddEmployee(stffName);
						}
						else 
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
							
					case 2:
						if(isAdmin) 
						{
							b1.viewAllEmployees();
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 3:
						if(isAdmin)
						{
							System.out.print("Enter staff id: ");
							String stffId = "";
							stffId = sc.next();
							b1.viewEmployeeWithId(stffId);
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 4:
						if(isAdmin)
						{
							System.out.print("Enter staff id: ");
							String stffId2 = "";
							stffId2 = sc.next();
							b1.removeEmployee(stffId2);
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
							
					case 5:
						if(isAdmin)
						{
							b1.employeeOperationLogs();	
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
							
					case 6:
						if(isAdmin)
						{
							System.out.print("Enter staff id: ");
							String stffId3 = "";
							stffId3 = sc.nextLine();
							b1.perticularEmployeeOperationLogs(stffId3);	
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 7:
						if(isAdmin)
						{
							System.out.println("Enter the operation: ");
							String opern = sc.next();
							b1.viewEmployeesWrtOperation(opern);
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 8:
						if(isAdmin)
						{
							System.out.println("Bill Info");
							b1.viewAllCustomersBillInfo();
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 9:
						if(isAdmin)
						{
							System.out.print("Enter customer mob no:(5 digit): ");
							String mobNo = sc.next();
							b1.viewPerticularCustomerBillInfo(mobNo);
						}
						else
						{
							System.out.println("Only Admin can Access this Operation!!");
						}
						break;
						
					case 10:
						b1.viewProducts();
						break;
						
					case 11:
						System.out.println("---Product Addition---");
						System.out.print("Product Name: ");
						String pname = sc.next();
						System.out.print("Product Brand: ");
						String brand = sc.next();
						System.out.print("Product Price: ");
						double price = sc.nextDouble();
						b1.addProductToInventory(pname, brand, price);
						break;
					
					case 12:
						System.out.print("Enter Product Name: ");
						String prdName = sc.next();
						b1.viewProduct(prdName);
						break;
						
					case 13:
						System.out.print("Enter Product Name to be Removed: ");
						String prdName2 = sc.next();
						b1.deleteProduct(prdName2);
						break;
						
					case 14:
						b1.showInventory();
						break;
						
					case 15:
						System.out.println("-----Generating Bill------");
						System.out.print("Enter customer Mob no.(5 digit): ");
						String mob = sc.next();
						b1.generateBill(mob);
						break;
						
					default:
						System.out.println("Invalid Selection");
				}
				
				System.out.print("Enter your choice to continue[0?exit-to change role] ");
				choice = sc.nextInt();
					
				}while(choice != 0);
			

			
			System.out.print("Continue Application -"+"- 1/0?[y/n]: ");
		}while(roleChoice != 0);
		
		sc.close();
	}

}

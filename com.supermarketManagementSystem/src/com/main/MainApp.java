package com.main;

import com.business.BusinessLayer;


public class MainApp {

	public static void release_v_1_0_0(){
		
		System.out.println("\n-----------Product Related-----------\n");
		System.out.println("10. View Products");
		System.out.println("11. Add Product");
		
		BusinessLayer b1 = new BusinessLayer("B001");
		
		System.out.println("del prod");
		b1.deleteProduct("Parle-g");
		
		System.out.println("Viewing products");
		
		b1.showInventory();
		
		String pname = "Kitkat";
		String brand = "Britania";
		double price = 19.56;
		b1.addProductToInventory(pname, brand, price);
		b1.deleteProduct("Parle-g");
		
		pname = "socks";
		brand = "Fila";
		price = 99;
		b1.addProductToInventory(pname, brand, price);
		
		pname = "milk";
		brand = "Amul";
		price = 52;
		b1.addProductToInventory(pname, brand, price);
		pname = "milk";
		brand = "Amul";
		price = 52;
		b1.addProductToInventory(pname, brand, price);
		
		pname = "Eraser";
		brand = "Apsara";
		price = 3;
		b1.addProductToInventory(pname, brand, price);
		
		pname = "socks";
		brand = "Fila";
		price = 99;
		b1.addProductToInventory(pname, brand, price);
		pname = "socks";
		brand = "Fila";
		price = 99;
		b1.addProductToInventory(pname, brand, price);
		pname = "socks";
		brand = "Fila";
		price = 99;
		b1.addProductToInventory(pname, brand, price);
		
		b1.showInventory();
		b1.deleteProduct("milk");
		b1.showInventory();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		release_v_1_0_0();
		
	}

}

package com.modals;

import java.time.LocalDate;
import java.util.Objects;

public class Product implements Comparable<Product>{
	
	private String product_id;
	private String product_name;
	private String brand;
	private LocalDate expdate;
	private double pricePerProduct;
	
	public Product(String product_id, String product_name, String brand, LocalDate expdate, double pricePerProduct) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.brand = brand;
		this.expdate = expdate;
		this.pricePerProduct = pricePerProduct;
	}
	
	public Product(String product_name, String brand, LocalDate expdate, double pricePerProduct) {
		super();
		this.product_name = product_name;
		this.brand = brand;
		this.expdate = expdate;
		this.pricePerProduct = pricePerProduct;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}

	public double getPricePerProduct() {
		return pricePerProduct;
	}

	public void setPricePerProduct(double pricePerProduct) {
		this.pricePerProduct = pricePerProduct;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, product_name);
	}

	@Override
	public boolean equals(Object obj) {
		return this.product_name == ((Product)obj).product_name;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", brand=" + brand
				+ ", expdate=" + expdate + ", pricePerProduct=" + pricePerProduct + "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.product_name.compareTo(o.product_name);
	}
	
}

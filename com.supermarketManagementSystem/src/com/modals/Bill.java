package com.modals;

import java.time.LocalDateTime;
import java.util.Set;

public class Bill implements Comparable<Bill>{

	private String bill_id;
	private String genStaffId;
	private LocalDateTime dateTime;
	private Cart smallCart;
	private double total;
	
	public Bill(String bill_id, String genStaffId, LocalDateTime dateTime, Cart smallCart, double total) {
		super();
		this.bill_id = bill_id;
		this.genStaffId = genStaffId;
		this.dateTime = dateTime;
		this.smallCart = smallCart;
		this.total = total;
	}

//	public Bill(String bill_id, String genStaffId, LocalDateTime dateTime) {
//		super();
//		this.bill_id = bill_id;
//		this.genStaffId = genStaffId;
//		this.dateTime = dateTime;
//	}

	public String getBill_id() {
		return bill_id;
	}

	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}

	public String getGenStaffId() {
		return genStaffId;
	}

	public void setGenStaffId(String genStaffId) {
		this.genStaffId = genStaffId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Cart getSmallCart() {
		return smallCart;
	}

	public void setSmallCart(Cart smallCart) {
		this.smallCart = smallCart;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", genStaffId=" + genStaffId + ", dateTime=" + dateTime + ", smallCart="
				+ smallCart + ", total=" + total + "]";
	}

	@Override
	public int compareTo(Bill o) {
		/*we compare the bills by date. If 2 bills are there with same date then arrange as per bill ID*/
		
		if(this.dateTime.compareTo(o.dateTime) < 0) {
			return -1;
		}else if(this.dateTime.compareTo(o.dateTime) > 0) {
			return 1;
		}else {
			return this.bill_id.compareTo(o.bill_id);
		}
		
	}
}

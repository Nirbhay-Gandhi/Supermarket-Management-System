package com.dao;

public class Factory {
	
	public static StaffDaoIntf getStaffDaoImpl() {
		return new StaffDaoImpl();
	}
	
	public static OwnerDaoIntf getOwnerSaoImpl() {
		return new OwnerDaoImpl();
	}
}

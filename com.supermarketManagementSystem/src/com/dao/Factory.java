package com.dao;

import com.Interface.OwnerDaoIntf;
import com.Interface.StaffDaoIntf;

public class Factory {
	
	public static StaffDaoIntf getStaffDaoImpl() {
		return new StaffDaoImpl();
	}
	
	public static OwnerDaoIntf getOwnerSaoImpl() {
		return new OwnerDaoImpl();
	}
}

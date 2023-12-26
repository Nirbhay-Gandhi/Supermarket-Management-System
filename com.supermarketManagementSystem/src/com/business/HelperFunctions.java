package com.business;

import com.dao.DataStructures;

public class HelperFunctions {
	
	static DataStructures ds;
	
	public HelperFunctions() {
		ds = new DataStructures();
	}
	
	public static String generateStaffId() 
	{
		String totalElements = String.valueOf(ds.getStaffInfoSize());
    	String sID = "S";
    	if(totalElements.length() == 1) {
    		sID = sID + "00" + totalElements;
    	}else if(totalElements.length() == 2) {
    		sID = sID + "0" + totalElements;
    	}else {
    		sID = sID + totalElements;
    	}
    	return sID;
    }
	
	public static String generateProductId() 
	{
		String totalElements = String.valueOf(ds.getProductInventorySize());
		String pID = "P";
		if(totalElements.length() == 1) {
			pID = pID + "00" + totalElements;
		}else if(totalElements.length() == 2) {
			pID = pID + "0" + totalElements;
		}else {
			pID = pID + totalElements;
		}
		return pID;
	}
	
    public static String generateBillId() 
    {
    	//generate bill id based on the Bills Set. If Set<Bills> = {...,B091,B092,} next should be B093
    	
    	//String totalElements = String.valueOf(ds.getBills().size()); this is not proper method, cause getBills() 
    	//will return an entire collection. just using 'ds.bills.size()' was okay, cause we were using its reference
    	String totalElements = String.valueOf(ds.getBillsSize());
    	String bID = "B";
    	if(totalElements.length() == 1) {
    		bID = bID + "00" + totalElements;
    	}else if(totalElements.length() == 2) {
    		bID = bID + "0" + totalElements;
    	}else {
    		bID = bID + totalElements;
    	}
    	return bID;
    }

}

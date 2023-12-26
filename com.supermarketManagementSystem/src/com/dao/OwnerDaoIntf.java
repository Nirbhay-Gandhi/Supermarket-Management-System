package com.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.modals.LocalStaff;
import com.modals.Product;

public interface OwnerDaoIntf{
	
	public Set<LocalStaff> viewStaffs();
	public LocalStaff viewStaff(String sid);
	public void addStaff(LocalStaff stf);
	public LocalStaff removeStaff(String sid);
	
	public Map<String, Map<String,List<String>>> viewAllStaffOperations();
	public Map<String,List<String>> viewStaffOperation(String StaffId);
	public Set<String> viewStaffsWrtOperation(String operation);
//	public void viewSpecificOperatedProducts(String operation);
	
}

package com.dao;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.modals.Bill;
import com.modals.Cart;
import com.modals.LocalStaff;
import com.modals.Product;

public class OwnerDaoImpl extends StaffDaoImpl implements OwnerDaoIntf{

	@Override
	public Set<LocalStaff> viewStaffs() {
		/*Note: we can see that we did instantiated DataStructers class, but still using its ref('ds')
		 * This is because we are inheriting StaffDaoImpl thats why. therwise we have to create the object
		 * of DataStructures class here as well*/
		return ds.staffInfo; 
	}

	@Override
	public LocalStaff viewStaff(String sid) {
		// TODO Auto-generated method stub
		Iterator<LocalStaff> itr = ds.staffInfo.iterator();
		while(itr.hasNext()) {
			LocalStaff staff = itr.next();
			if(staff.getStaffId().equals(sid)) {
				return staff;
			}
		}
		return null;
	}

	@Override
	public void addStaff(LocalStaff stf) {
		// TODO Auto-generated method stub
		ds.staffInfo.add(stf);
	}

	@Override
	public LocalStaff removeStaff(String sid) {
		// TODO Auto-generated method stub
		Iterator<LocalStaff> itr = ds.staffInfo.iterator();
		while(itr.hasNext()) {
			LocalStaff stf = itr.next();
			if(stf.getStaffId().equals(sid)) {
				itr.remove();
				return stf;
			}
		}
		return null;
	}

	@Override
	public Map<String, Map<String,List<String>>> viewAllStaffOperations() {
		// TODO Auto-generated method stub
		return ds.inventoryOpration;
	}

	@Override
	public Map<String,List<String>> viewStaffOperation(String StaffId) {
		//iterating over map. first extract entryset then iterate over the map
		Set<Map.Entry<String, Map<String,List<String>>>> allStfOpernSet = ds.inventoryOpration.entrySet();
		Iterator<Map.Entry<String, Map<String,List<String>>>> allStfOpernSetItr = allStfOpernSet.iterator();
		
		while(allStfOpernSetItr.hasNext()) {
			/*singleStfOpernEntry Viz: [P101={Add=['apple','banana'],Update=['mango']}]*/
			Map.Entry<String, Map<String,List<String>>> singleStfOpernEntry = allStfOpernSetItr.next(); 
			
			if(singleStfOpernEntry.getKey().equals(StaffId)) {
				Map<String,List<String>> givenStfOpern = singleStfOpernEntry.getValue();
				return givenStfOpern;
			}
		}
		return null;
	}

	public Set<String> viewStaffsWrtOperation(String operation) {
		Set<String> staffPerformDesiredOpern = new LinkedHashSet<>();
		
		//iterating over map
		Set<Map.Entry<String, Map<String, List<String>>>> allStfOpernSet = ds.inventoryOpration.entrySet();
		Iterator<Map.Entry<String, Map<String, List<String>>>> allStfOpernSetItr = allStfOpernSet.iterator();
		
		while(allStfOpernSetItr.hasNext()) 
		{
			/*singleStfOpernEntry Viz: [P101={Add=['apple','banana'],Update=['mango']}]*/
			Map.Entry<String, Map<String,List<String>>> singleStfOpernEntry = allStfOpernSetItr.next();
			String currentStaffId = singleStfOpernEntry.getKey();
			
			//still iterate over the inner map
			Set<Map.Entry<String, List<String>>> opernsMapSet = singleStfOpernEntry.getValue().entrySet();
			Iterator<Map.Entry<String, List<String>>> singleStfOpernItr = opernsMapSet.iterator();
			
			while(singleStfOpernItr.hasNext()) 
			{
				Map.Entry<String, List<String>> perticularStfOpernEntry = singleStfOpernItr.next();
				
				if(perticularStfOpernEntry.getKey().equals(operation)) {
					staffPerformDesiredOpern.add(currentStaffId);
					break;
				}
			}
		}
		return staffPerformDesiredOpern;
	}
}

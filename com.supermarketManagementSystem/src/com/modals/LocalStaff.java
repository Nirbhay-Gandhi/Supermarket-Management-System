package com.modals;

import java.util.Objects;

public class LocalStaff implements Comparable<LocalStaff>{
	
	private String staffId;
	private String name;
	
	public LocalStaff(String staffId, String name) {
		super();
		this.staffId = staffId;
		this.name = name;
	}
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(staffId);
	}

	@Override
	public boolean equals(Object obj) {
		return this.staffId == ((LocalStaff)obj).staffId;
	}

	@Override
	public int compareTo(LocalStaff o) {
		// TODO Auto-generated method stub
		return this.staffId.compareTo(o.staffId);
	}

	@Override
	public String toString() {
		return "LocalStaff [staffId=" + staffId + ", name=" + name + "]";
	}
	
}

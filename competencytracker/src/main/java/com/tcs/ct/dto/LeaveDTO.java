package com.tcs.ct.dto;

import java.util.Date;

public class LeaveDTO {
String empId;	
Date startDate;
Date endDate;
boolean isApplied;
String reason;

public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public boolean isApplied() {
	return isApplied;
}
public void setApplied(boolean isApplied) {
	this.isApplied = isApplied;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}

}

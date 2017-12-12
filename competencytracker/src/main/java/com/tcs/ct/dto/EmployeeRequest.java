package com.tcs.ct.dto;

import java.util.List;

public class EmployeeRequest {

	Integer employeeId;
	String employeeName;
	String employeeEmail;
	String employeePhone;
	String employeeDomain;
	List<Competency> competencyList;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public List<Competency> getCompetencyList() {
		return competencyList;
	}
	public void setCompetencyList(List<Competency> competencyList) {
		this.competencyList = competencyList;
	}
	
}

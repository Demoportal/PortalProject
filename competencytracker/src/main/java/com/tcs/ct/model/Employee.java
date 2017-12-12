package com.tcs.ct.model;

import java.util.List;

import com.tcs.ct.dto.Competency;

public class Employee {
	
	Integer employeeId;
	String employeeName;
	String employeeEmail;
	String employeePhone;
	String employeeDomain;
	List<Competency> competencyList;
	
	
	public List<Competency> getCompetencyList() {
		return competencyList;
	}
	public void setCompetencyList(List<Competency> competencyList) {
		this.competencyList = competencyList;
	}
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

}

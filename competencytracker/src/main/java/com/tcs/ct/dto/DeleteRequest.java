package com.tcs.ct.dto;

import java.util.List;

public class DeleteRequest {

	List <Integer>competencyList;
	Integer employeeId;
	
	public List<Integer> getCompetencyList() {
		return competencyList;
	}
	public void setCompetencyList(List<Integer> competencyList) {
		this.competencyList = competencyList;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}

package com.tcs.ct.dto;

import java.util.List;

public class DeleteRequest {

	List <Competency>competencyList;
	Integer employeeId;
	
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
	
}

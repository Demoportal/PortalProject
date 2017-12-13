package com.tcs.ct.dto;

public class AddCompRequest {

	Integer employeeId;
	Competency competency;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Competency getCompetency() {
		return competency;
	}
	public void setCompetency(Competency competency) {
		this.competency = competency;
	}
	
}

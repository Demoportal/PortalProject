package com.tcs.ct.dto;

import java.util.List;

public class AddAllCompRequest {
	Integer competencyId;
	String competencyName;
	List<String> compList;
	
	
	public Integer getCompetencyId() {
		return competencyId;
	}
	public void setCompetencyId(Integer competencyId) {
		this.competencyId = competencyId;
	}
	public String getCompetencyName() {
		return competencyName;
	}
	public void setCompetencyName(String competencyName) {
		this.competencyName = competencyName;
	}
	public List<String> getCompList() {
		return compList;
	}
	public void setCompList(List<String> compList) {
		this.compList = compList;
	}
	

}

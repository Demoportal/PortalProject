package com.tcs.ct.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CompetencyDetails")
public class CompetencyDetails {

	@Id
	Integer compId;
	
	String compName;
	List<String> compList;
	
	public List<String> getCompList() {
		return compList;
	}
	public void setCompList(List<String> compList) {
		this.compList = compList;
	}
	
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	
	
}

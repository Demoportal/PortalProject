package com.tcs.ct.dto;

public class Competency {
	
	Integer competencyId;
	String competencyName;
	String competencyLevel;
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
	public String getCompetencyLevel() {
		return competencyLevel;
	}
	public void setCompetencyLevel(String competencyLevel) {
		this.competencyLevel = competencyLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competencyId == null) ? 0 : competencyId.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competency other = (Competency) obj;
		if (competencyId == null) {
			if (other.competencyId != null)
				return false;
		} else if (!competencyId.equals(other.competencyId))
			return false;
		
		return true;
	}
	
	
	

}

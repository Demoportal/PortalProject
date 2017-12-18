package com.tcs.ct.exception;

public class CompetencyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messsage;
	 public CompetencyException(Exception e) {
	        super(e);
	    }
	public CompetencyException(String messsage) {
		// TODO Auto-generated constructor stub
		
		this.messsage=messsage;
		
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return messsage;
	}


}

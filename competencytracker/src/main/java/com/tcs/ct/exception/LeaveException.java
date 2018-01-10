package com.tcs.ct.exception;

public class LeaveException  extends Exception{
	private static final long serialVersionUID = 1L;
	private String messsage;
	 public LeaveException(Exception e) {
	        super(e);
	    }
	public LeaveException(String messsage) {
		// TODO Auto-generated constructor stub
		
		this.messsage=messsage;
		
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return messsage;
	}

}

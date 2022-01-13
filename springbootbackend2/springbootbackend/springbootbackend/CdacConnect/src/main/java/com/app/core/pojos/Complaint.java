package com.app.core.pojos;

public enum Complaint {
  Active,Unactive,waiting;
	
	@Override
	public String toString()
	{
		return name().toUpperCase();
	}

}

package com.app.core.pojos;

public enum StudentStatus {
	
verified,unverified;
	
	@Override
	public String toString()
	{
		return name().toUpperCase();
	}

}

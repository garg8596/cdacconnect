package com.app.core.pojos;

public enum Gender {
	
Male, Female, Other;
	
	@Override
	public String toString()
	{
		return name().toUpperCase();
	}

}




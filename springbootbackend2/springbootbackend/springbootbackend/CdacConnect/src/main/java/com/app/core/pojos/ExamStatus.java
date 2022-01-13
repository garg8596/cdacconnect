package com.app.core.pojos;

public enum ExamStatus {
	
	Passed,Fail,Waiting;
	@Override
	public String toString()
	{
		return name().toUpperCase();
	}

}

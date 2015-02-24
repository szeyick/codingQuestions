package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link IEmployee}
 * <p>
 * This interface class represents the common employee
 * interface that all types of employees will implement. 
 * It provides common methods to all employee objects.
 * <p>
 * @author szeyick
 */
public abstract class Employee {

	/**
	 * The method that employees implement
	 * to answer the call.
	 */
	public void respond(Call call) {
		call.updateCallState(CallState.ANSWERED, getEmployeeName());
	}
	
	/**
	 * @return - The name of the employee.
	 */
	public abstract String getEmployeeName();
}

package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link Director}
 * <p>
 * The class represents the manager in the
 * call centre example. It is the first point
 * of contact for all {@link Call} objects. 
 * <p>
 * @author szeyick
 */
public class Director extends Employee {

	/**
	 * The name of the respondent.
	 */
	private String employeeName;
	
	/**
	 * Constructor.
	 * @param employeeNameTmp - The employee name.
	 */
	public Director(String employeeNameTmp) {
		employeeName = employeeNameTmp;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEmployeeName() {
		return employeeName;
	}

}

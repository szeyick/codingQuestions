package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link Respondent}
 * <p>
 * The class represents the respondent in the
 * call centre example. It is the first point
 * of contact for all {@link Call} objects. 
 * <p>
 * @author szeyick
 */
public class Respondent extends Employee {

	/**
	 * The name of the respondent.
	 */
	private String employeeName;
	
	/**
	 * Constructor.
	 * @param employeeNameTmp - The employee name.
	 */
	public Respondent(String employeeNameTmp) {
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

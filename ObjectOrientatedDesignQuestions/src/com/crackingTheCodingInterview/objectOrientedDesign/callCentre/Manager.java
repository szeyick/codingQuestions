package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link Manager}
 * <p>
 * The class represents the manager in the
 * call centre example. It is the first point
 * of contact for all {@link Call} objects. 
 * <p>
 * @author szeyick
 */
public class Manager extends Employee {

	/**
	 * The name of the manager.
	 */
	private String employeeName;
	
	/**
	 * Constructor.
	 * @param employeeNameTmp - The employee name.
	 */
	public Manager(String employeeNameTmp) {
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

package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link Call}
 * <p>
 * This class acts as the message object that is passed
 * from the client to the employee. 
 * <p>
 * @author szeyick
 */
public class Call {

	/**
	 * The current state of the call.
	 */
	private CallState callState;
	
	/**
	 * The name of the employee that answered the call.
	 */
	private String employeeName;
	
	/**
	 * Constructor.
	 */
	public Call() {
		callState = CallState.UNANSWERED;
		employeeName = null;
	}
	
	/**
	 * Update the state of the current call.
	 * @param state - The new state of the call.
	 */
	public void updateCallState(CallState state, String employeeName) {
		callState = state;
		this.employeeName = employeeName;
	}
	
	/**
	 * @return - The current state of the call.
	 */
	public CallState getCallState() {
		return callState;
	}
	
	/**
	 * @return - The name of the employee that answered the call
	 * or null if unresponded.
	 */
	public String getEmployeeName() {
		return employeeName;
	}
}

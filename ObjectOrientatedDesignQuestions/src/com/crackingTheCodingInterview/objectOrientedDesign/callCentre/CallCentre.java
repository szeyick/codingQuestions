package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link CallCentre}
 * <p>
 * This class represents the call centre. It is responsible
 * for managing all the {@link Employee} objects and acts as 
 * the mediator between the client and employees.
 * <p>
 * @author szeyick
 */
public class CallCentre {

	/**
	 * The list of respondents able to take the call.
	 */
	private List<Employee> respondents;
	
	/**
	 * The list of managers able to take the call.
	 */
	private List<Employee> managers;
	
	/**
	 * The list of directors able to take the call.
	 */
	private List<Employee> directors;
	
	/**
	 * The constructor.
	 */
	public CallCentre() {
		respondents = new ArrayList<Employee>();
		managers = new ArrayList<Employee>();
		directors = new ArrayList<Employee>();
	}
	
	/**
	 * Add a respondent to the call centre.
	 * @param respondent - The respondent to add.
	 */
	public void addRespondent(Employee respondent) {
		respondents.add(respondent);
	}
	
	/**
	 * Add a manager to respond to the call.
	 * @param managers - The manager to respond the call.
	 */
	public void addManagers(Employee manager) {
		managers.add(manager);
	}
	
	/**
	 * Add a director to respond to the call.
	 * @param director - The director to respond to
	 * the call.
	 */
	public void addDirector(Employee director) {
		directors.add(director);
	}
	
	/**
	 * Method implemented by the call centre object
	 * to re-direct the calls to the correct person.
	 * @param call - The call.
	 * @return The original call object.
	 */
	public Call dispatchCall(Call call) {
		respondCall(call, respondents);
		if (CallState.UNANSWERED.equals(call.getCallState())) {
			respondCall(call, managers);	
		}
		if (CallState.UNANSWERED.equals(call.getCallState())) {
			respondCall(call, directors);	
		}
		return call;
	}

	/**
	 * Generic method allowing different call takers to respond to a call.
	 * @param call
	 * @param availableCallTakes
	 * @return
	 */
	private Call respondCall(Call call, List<Employee> availableCallTakers) {
		Employee responder = null;
		for (Employee employee : availableCallTakers) {
			if (CallState.UNANSWERED.equals(call.getCallState())) {
				employee.respond(call);
				responder = employee;
			}
			else {
				// Once a call has been responded to we do not need to pass on.
				break; 
			}
		}
		// If a responder responds to a call, remove them from the list of available
		// people to take a call.
		if (responder != null) {
			availableCallTakers.remove(responder);
		}
		return call;
	}
}

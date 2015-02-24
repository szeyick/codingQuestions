package com.crackingTheCodingInterview.objectOrientedDesign.callCentre;

/**
 * The {@link Client}
 * <p>
 * This class represents the program main. It doubles
 * as the client that sends the call requests to the
 * {@link CallCentre}. 
 * <p>
 * It creates all the required objects used in this example.
 * <p>
 * @author szeyick
 */
public class Client {
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		CallCentre callCentre = new CallCentre();
		callCentre.addRespondent(createRespondent("Dave"));
		callCentre.addManagers(createManager("Lethario"));
		callCentre.addDirector(createDirector("Gru"));

		// Place numerous calls to the call centre.
		for (int i = 0; i < 4; i++) {
			placeCall(callCentre);
		}
	}
	
	/**
	 * Place a call.
	 * @param callCentre - The call centre to manage the calls.
	 */
	private static void placeCall(CallCentre callCentre) {
		Call call = createCall();
		call = callCentre.dispatchCall(call);
		callMessage(call);
	}
	
	/**
	 * The message to output once the call has been handled by the call centre.
	 * @param call
	 */
	private static void callMessage(Call call) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Call State - " + call.getCallState());
		
		// If the call is answered add the name of the person who took the call.
		if (CallState.ANSWERED.equals(call.getCallState())) {
			stringBuilder.append(" answered by - " + call.getEmployeeName());
		}
		System.out.println(stringBuilder.toString());
	}
	
	/**
	 * @return - A new call object.
	 */
	private static Call createCall() {
		return new Call();
	}
	/**
	 * Create a new respondent.
	 * @param name - The name of the respondent to take the call.
	 * @return - The respondent.
	 */
	private static Employee createRespondent(String name) {
		return new Respondent(name);
	}
	
	/**
	 * Create a new respondent.
	 * @param name - The name of the manger to take the call.
	 * @return - The manager.
	 */
	private static Manager createManager(String name) {
		return new Manager(name);
	}
	
	/**
	 * Create a new director.
	 * @param name - The name of the director to take the call.
	 * @return - The director.
	 */
	private static Director createDirector(String name) {
		return new Director(name);
	}
}

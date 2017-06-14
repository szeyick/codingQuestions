package com.airwallexChallenge.rpnCalculator;

import java.util.Scanner;

/**
 * The ApplicationMain.
 * <p>
 * This class represents the application entry point for
 * the RPN (Reverse Polish Notation) calculator.
 * <p>
 * @author szeyick
 */
public class ApplicationMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RPNCalculator calculator = new RPNCalculator();
		displayMenu();
		Scanner in = new Scanner(System.in);
		while (true) {
			String inputString = in.nextLine();
			if ("Exit".equals(inputString)) {
				break;
			}
			calculator.processInput(inputString);
		}
		System.out.println("Goodbye!");
	}

	/**
	 * Build the menu the display.
	 */
	private static void displayMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("==============RPN Calculator=================");
		builder.append("\n");
		builder.append("Type Exit to Quit:");
		builder.append("\n");
		builder.append("=============================================");
		System.out.println(builder.toString());
	}
}

package com.codingQuestions.main;

/**
 * The CalculateStringExpression.
 * <p>
 * Given an arithmetic expression represented as a 
 * string, calculate and provide the output.
 * <p>
 * <b>Warning: <b/>None.
 * @author szeyick
 */
public class CalculateStringExpression {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		String expression = "1111*2+10*10*2+1"; 
		StringExpressionCalculator calculator = new StringExpressionCalculator();
		
		int total = calculator.calculateExpression(expression);
		System.out.println(expression + " = " + total);
	}
}

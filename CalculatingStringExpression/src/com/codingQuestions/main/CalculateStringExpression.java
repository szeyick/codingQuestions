package com.codingQuestions.main;

import java.util.ArrayList;
import java.util.List;

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
		List<String> expressionList = processExpression(expression);
		int total = computeExpression(expressionList);
		System.out.println(expression + " = " + total);
	}
	
	/**
	 * Evaluate the expression from the list of strings provided.
	 * @param expressionList - The list of expressions.
	 * @return the computed total.
	 */
	private static int computeExpression(List<String> expressionList) {
		// Iterate through each expression.
		int sum = 0;
		int currentIndex = 0;
		int nextIndex = currentIndex + 1;
		
		while (currentIndex < expressionList.size()) {
			String operand = expressionList.get(currentIndex);
			nextIndex = currentIndex + 1;
			if (nextIndex < expressionList.size()) {
				String operator = expressionList.get(nextIndex);
				if (operator.equals("+")) {
					sum += Integer.valueOf(operand);
					currentIndex = nextIndex + 1;
				}
				else if (operator.equals("*")) {
					// Find the substring. Since we need to find all 10*10*2
					int endIndex = findMultiplicationSubString(currentIndex, expressionList);
					int value = findMultipliedValue(currentIndex, endIndex, expressionList);
					sum += value;
					currentIndex = endIndex + 1; // Skip ahead as all in between has already been processed.
				}
			}
			else {
				sum += Integer.valueOf(operand);
				currentIndex++;
			}
		}
		return sum;
	}
	
	/**
	 * Compute the multiplication string.
	 * @param currentIndex - The start index of the multiplication string.
	 * @param endIndex - The end index of the multiplication string.
	 * @param expressionList - The list of expressions.
	 * @return the multiplied value.
	 */
	private static int findMultipliedValue(int currentIndex, int endIndex, List<String> expressionList) {
		int value = 1; // If you multiply by 0, the sum will always be 0
		for (int i = currentIndex; i < endIndex; i++) {
			String expression = expressionList.get(i);
			if (!"*".equals(expression)) {
				value *= Integer.valueOf(expression);
			}
		}
		return value;
	}
	
	/**
	 * Given a multiplication string, find the index in which it stops (either end of list or +)
	 * @param currentIndex - The current index where the multiplication begins.
	 * @param expressionList - The list of expressions.
	 * @return the index where the multiplication substring ends.
	 */
	private static int findMultiplicationSubString(int currentIndex, List<String> expressionList) {
		int endIndex = currentIndex;
		for (int i = currentIndex; i < expressionList.size(); i++) {
			if (expressionList.get(i).equals("+")) {
				break;
			}
			endIndex++;
		}
		return endIndex;
	}
	
	/**
	 * Break the string up into operands and operators.
	 * @param expression - The string expression.
	 * @return the expression broken up into individual strings.
	 */
	private static List<String> processExpression(String expression) {
		List<String> expressionList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			// If it is a number, we need to append them together.
			if (c >= '0' && c <= '9') {
				builder.append(c);
			}
			else if (c == '+' || c == '*') {
				addStringToList(expressionList, builder, c);
			}
		}
		expressionList.add(builder.toString());
		return expressionList;
	}
	
	/**
	 * Add the expression to the list.
	 * @param expressionList - The list to add the expression to.
	 * @param builder - The builder containing the operand.
	 * @param c - the operator.
	 */
	private static void addStringToList(List<String> expressionList, StringBuilder builder, char c) {
		expressionList.add(builder.toString());
		expressionList.add(String.valueOf(c));
		builder.setLength(0); // Reset the string builder to 0.
	}
}

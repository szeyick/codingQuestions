package com.airwallexChallenge.rpnCalculator.main.operators;

/**
 * The OperatorEnum.
 * <p>
 * This class represents the enums of operators that are
 * available for the RPN calculator.
 * <p>
 * @author szeyick
 */
public enum OperatorEnum {

	ADD,

	MULTIPLY,

	DIVIDE,

	SUBTRACT,

	SQUARE_ROOT,

	CLEAR,

	UNDO,

	NOT_OPERATOR;

	/**
	 * @param inputString - The user input string.
	 * @return the enum representing the operator, or invalid if it
	 * is not an operator (i.e. could be value).
	 */
	public static OperatorEnum convertStringToOperator(String inputString) {
		OperatorEnum operator = NOT_OPERATOR;
		switch (inputString) {
		case "+":
			operator = OperatorEnum.ADD;
			break;
		case "*":
			operator = OperatorEnum.MULTIPLY;
			break;
		case "/":
			operator = OperatorEnum.DIVIDE;
			break;
		case "-":
			operator = OperatorEnum.SUBTRACT;
			break;
		case "sqrt":
			operator = OperatorEnum.SQUARE_ROOT;
			break;
		case "undo":
			operator = OperatorEnum.UNDO;
			break;
		case "clear":
			operator = OperatorEnum.CLEAR;
			break;
		default:
			break;
		}
		return operator;
	}
}
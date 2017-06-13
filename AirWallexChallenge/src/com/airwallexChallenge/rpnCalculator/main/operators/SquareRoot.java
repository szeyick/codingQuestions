package com.airwallexChallenge.rpnCalculator.main.operators;

import java.util.Stack;

/**
 * The SquareRoot.
 * <p>
 * This class is responsible for performing a square root operation for a single
 * value from the input stack.
 * <p>
 * <b>Warning: </b>To perform a square root operation, the input stack must have at least
 * a single value, otherwise the operation is not performed.
 * <p>
 * @author szeyick
 */
public class SquareRoot implements IOperatorStrategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOperation(Stack<Double> valueStack) {
		boolean operationPerformed = false;
		if (valueStack.size() > 0) {
			Double value = valueStack.pop();
			
			valueStack.push(Math.sqrt(value));
			operationPerformed = true;
		}
		return operationPerformed;
	}
}

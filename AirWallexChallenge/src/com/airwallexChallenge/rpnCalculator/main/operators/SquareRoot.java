package com.airwallexChallenge.rpnCalculator.main.operators;

import java.util.Deque;

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
	public boolean performOperation(Deque<Double> valueStack) {
		boolean operationPerformed = false;
		if (!valueStack.isEmpty()) {
			Double value = valueStack.pollLast();
			
			valueStack.addLast(Math.sqrt(value));
			operationPerformed = true;
		}
		return operationPerformed;
	}
}
package com.airwallexChallenge.rpnCalculator.main.operators.basic;

import java.util.Deque;

/**
 * The Division.
 * <p>
 * This class is responsible for performing the division operation for a given
 * stack of values. 
 * <p>
 * <b>Warning: </b>Because values are popped off the stack, the first value
 * popped off the stack is the denominator and the second value popped off the
 * stack is the numerator. Also to protect against "divide by zero" errors, if
 * the denominator is 0, the division is not invoked.
 * <p>
 * @author szeyick
 */
public class Division extends BasicOperation {

	/**
	 * {@inheritDoc} 
	 */
	@Override
	protected Double computeSum(Double firstValue, Double secondValue) {
			return secondValue / firstValue;
	}
	
	/**
	 * @param valueStack - The stack of input values.
	 * @return <code>true</code> if the operation is performed, <code>false</code> otherwise.
	 */
	@Override
	public boolean performOperation(Deque<Double> valueStack) {
		boolean operationPerformed = false;
		if (valueStack.size() >= 2) {
			// Pop the top two values off the stack and perform an operation.
			if (valueStack.peekLast() != 0) {
				Double firstValue = valueStack.pollLast();
				Double secondValue = valueStack.pollLast();

				valueStack.addLast(computeSum(firstValue, secondValue));
				operationPerformed = true;
			}
		}
		return operationPerformed;
	}
}

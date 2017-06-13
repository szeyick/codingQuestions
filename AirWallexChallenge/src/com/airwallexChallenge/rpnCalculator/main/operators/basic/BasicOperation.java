package com.airwallexChallenge.rpnCalculator.main.operators.basic;

import java.util.Deque;
import java.util.Stack;

import com.airwallexChallenge.rpnCalculator.main.operators.IOperatorStrategy;

/**
 * The BasicOperation.
 * <p>
 * This abstract class is responsible for performing generic operations
 * for simple arithmetic operators. It is responsible for popping two values off
 * a given input stack and passing the popped values to its children to evaluate.
 * <p>
 * <b>Warning: </b>This class will only continue processing if there are at least two
 * values on the input stack, otherwise the operation is not processed and control is
 * immediately returned to the caller.
 * <p>
 * @author szeyick
 */
public abstract class BasicOperation implements IOperatorStrategy {

	/**
	 * Abstract method for child implementing classes to compute the total
	 * given two values.
	 * @param firstValue - The first value to sum.
	 * @param secondValue - The second value to sum.
	 * @return the computed total based off child implementing class.
	 */
	protected abstract Double computeSum(Double firstValue, Double secondValue);

	/**
	 * @param valueStack - The stack of input values.
	 * @return <code>true</code> if the operation is performed, <code>false</code> otherwise.
	 */
	@Override
	public boolean performOperation(Deque<Double> valueStack) {
		boolean operationPerformed = false;
		if (valueStack.size() >= 2) {
			// Pop the top two values off the stack and perform an operation.
			Double firstValue = valueStack.pollLast();
			Double secondValue = valueStack.pollLast();

			valueStack.addLast(computeSum(firstValue, secondValue));
			operationPerformed = true;
		}
		return operationPerformed;
	}
}

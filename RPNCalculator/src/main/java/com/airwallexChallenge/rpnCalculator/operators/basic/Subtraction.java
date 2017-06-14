package com.airwallexChallenge.rpnCalculator.operators.basic;

/**
 * The Subtraction.
 * <p>
 * This class is responsible for performing the subtraction operation for a given
 * stack of values.
 * <p>
 * <b>Warning: </b>The first value popped off the stack is subtracted from the second
 * value popped off the stack.
 * <p>
 * @author szeyick
 */
public class Subtraction extends BasicOperation {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Double computeSum(Double firstValue, Double secondValue) {
		return secondValue - firstValue;
	}
}

package com.airwallexChallenge.rpnCalculator.main.operators.basic;

/**
 * The Division.
 * <p>
 * This class is responsible for performing the division operation for a given
 * stack of values. 
 * <p>
 * <b>Warning: </b>Because values are popped off the stack, the first value
 * popped off the stack is the denominator and the second value popped off the
 * stack is the numerator.
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
}

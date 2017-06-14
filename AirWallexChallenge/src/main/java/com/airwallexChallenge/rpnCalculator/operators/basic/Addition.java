package com.airwallexChallenge.rpnCalculator.operators.basic;

/**
 * The Addition.
 * <p>
 * This class is responsible for performing an addition operation for a given stack
 * of values. As a child of the {@link BasicOperation}, it will be passed in two
 * individual values to perform the addition operation on.
 * <p>
 * <b>Warning: </b>If the operation cannot be performed, a warning is displayed.
 * <p>
 * @author szeyick
 */
public class Addition extends BasicOperation {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Double computeSum(Double firstValue, Double secondValue) {
		return firstValue + secondValue;
	}
}

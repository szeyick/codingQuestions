package com.airwallexChallenge.rpnCalculator.main.operators.basic;

/**
 * The Multiplication.
 * <p>
 * This class is responsible for performing the multiplication operation for a given
 * stack of values. 
 * <p>
 * <b>Warning: </b>If the operation cannot be performed, a warning is displayed.
 * <p>
 * @author szeyick
 */
public class Multiplication extends BasicOperation {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Double computeSum(Double firstValue, Double secondValue) {
		return firstValue * secondValue;
	}
}
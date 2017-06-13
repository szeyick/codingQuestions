package com.airwallexChallenge.rpnCalculator.main.operators;

import java.util.Stack;

/**
 * The IOperatorStrategy.
 * <p>
 * This interface is responsible for providing a generic way for a child implementing
 * class to perform an operation for a given set of input. 
 * <p>
 * @author szeyick
 */
public interface IOperatorStrategy {

	/**
	 * @param valueStack - The stack of values to perform the operation on.
	 * @return <code>true</code> if the operation is completed, <code>false</code> otherwise.
	 */
	boolean performOperation(Stack<Double> valueStack);
	
}

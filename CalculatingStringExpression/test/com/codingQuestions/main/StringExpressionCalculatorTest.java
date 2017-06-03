package com.codingQuestions.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The CalculateStringExpressionTest.
 * <p>
 * This class is responsible for testing the {@link StringExpressionCalculator}
 * by passing it numerous values to validate the output.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 *
 */
public class StringExpressionCalculatorTest {

	/**
	 * Test the calculator.
	 */
	@Test
    public void testStringExpressions() {
		StringExpressionCalculator calculator = new StringExpressionCalculator();
		
		assertEquals("Expected values to be equal", 2, calculator.calculateExpression("1+1"));
		assertEquals("Expected values to be equal", 1, calculator.calculateExpression("5*3*2*0+1"));
		assertEquals("Expected values to be equal", 2423, calculator.calculateExpression("1111*2+10*10*2+1"));
		assertEquals("Expected values to be equal", 8, calculator.calculateExpression("1+1+2*3"));
    }
}

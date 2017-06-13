package com.airwallexChallenge.rpnCalculator.main;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.airwallexChallenge.rpnCalculator.main.RPNCalculator;

/**
 * The RPNCalculatorTest.
 * <p>
 * This class is responsible for testing the {@link RPNCalculator}.
 * <p>
 * <b>Warning: </b>For this test, the output that is printed by the calculator is
 * captured by the {@link ByteArrayOutputStream}. The reason that this is done is 
 * because the state of the calculator is not exposed, therefore to validate the
 * contents of the stack, we validate against the system output. 
 * <p>
 * @author szeyick
 */
public class RPNCalculatorTest {

	/**
	 * The class under test.
	 */
	private RPNCalculator calculator;
	
	/**
	 * The byte stream to validate the output.
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	/**
	 * Test setup
	 */
	@Before
	public void setup() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		calculator = new RPNCalculator();
        System.setOut(new PrintStream(outContent));
	}
	
	/**
	 * Test the calculator against the sample input provided by the
	 * specification sheet.
	 */
	@Test
	public void testExample1() {
		String inputString = "5 2";
		calculator.processInput(inputString);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 5 2 - ", output, containsString("5 2"));
	}
	
	/**
	 * Test the calculator against the sample input provided by the specification sheet.
	 */
	@Test
	public void testExample2() {
		String inputString1 = "2 sqrt";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 1.4142135623 - ", output, containsString("1.4142135623"));
		outContent.reset();
		
		String inputString2 = "clear 9 sqrt";
		calculator.processInput(inputString2);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 3 - ", output, containsString("3"));
		
		System.out.println();
	}
	
	/**
	 * Test the calculator against the sample input provided by the specification sheet.
	 */
	@Test 
	public void testExample3() {
		String inputString1 = "5 2  -";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 3 - ", output, containsString("3"));
		
		outContent.reset();
		
		String inputString2 = "3 -";
		calculator.processInput(inputString2);
		
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 0 - ", output, containsString("0"));
		
		String inputString3 = "clear";
		calculator.processInput(inputString3);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to be empty - ", output, containsString(""));
	}
	
	/**
	 * Test the calculator against the sample input provided by specification sheet.
	 */
	@Test
	public void testExample4() {
		String inputString1 = "5 4 3 2";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 5 4 3 2 - ", output, containsString("5 4 3 2"));

		outContent.reset();
		
		String inputString2 = "undo undo *";
		calculator.processInput(inputString2);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 20 - ", output, containsString("20"));
	}
	
	/**
	 * Test the calculator against the sample input provided by specification sheet.
	 */
	@Test
	public void testExample5() {
		String inputString1 = "7 12 2 /";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 7 6", output, containsString("7 6"));
		
		outContent.reset();
		
		String inputString2 = "*";
		calculator.processInput(inputString2);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 42 - ", output, containsString("42"));
		
		outContent.reset();
		
		String inputString3 = "4 /";
		calculator.processInput(inputString3);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 10.5 - ", output, containsString("10.5"));
	}
	
	/**
	 * Test the calculator against the sample input provided by specification sheet.
	 */
	@Test
	public void testExample6() {
		String inputString1 = "1 2 3 4 5";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 1 2 3 4 5", output, containsString("1 2 3 4 5"));
		
		outContent.reset();
		
		String inputString2 = "*";
		calculator.processInput(inputString2);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 1 2 3 20 - ", output, containsString("1 2 3 20"));
		
		outContent.reset();
		
		String inputString3 = "clear 3 4 -";
		calculator.processInput(inputString3);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain -1 - ", output, containsString("-1"));
	}
	
	/**
	 * Test the calculator against the sample input provided by specification sheet.
	 */
	@Test
	public void testExample7() {
		String inputString1 = "1 2 3 4 5";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 1 2 3 4 5", output, containsString("1 2 3 4 5"));
		
		outContent.reset();
		
		String inputString2 = "* * * *";
		calculator.processInput(inputString2);
		output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 120 - ", output, containsString("120"));
	}
	
	/**
	 * Test the calculator against the sample input provided by specification sheet.
	 */
	@Test
	public void testExample8() {
		String inputString1 = "1 2 3 * 5 + * * 6 5";
		calculator.processInput(inputString1);

		String[] outputString = outContent.toString().split("\n");
		
		String warning = outputString[0];
		String stackOutput = outputString[1].replaceAll("stack: ", "");
		assertThat("Expected a warning", warning, containsString("operator * (position: 15): insufficient parameters"));
		assertThat("Expected the stack to contain 11", stackOutput, containsString("11"));
	}
	
	/**
	 * Test the calculator against custom input.
	 */
	@Test
	public void testCustomInput() {
		String inputString1 = "5 1 2 + 4 * + 3 -";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 14", output, containsString("14"));
	}
	
	/**
	 * Test the calculator against custom input.
	 */
	@Test
	public void testCustomInput2() {
		String inputString1 = "2 1 + 3 *";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 9", output, containsString("9"));
	}
	
	/**
	 * Test the calculator against custom input.
	 */
	@Test
	public void testCustomInput3() {
		String inputString1 = "4 13 5 / +";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to contain 6", output, containsString("6"));
	}
	
	/**
	 * Test the calculator against custom input.
	 */
	@Test
	public void testCustomInput4() {
		String inputString1 = "undo undo";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to be empty", output, containsString(""));
	}
	
	/**
	 * Test the calculator against custom input.
	 */
	@Test
	public void testCustomInput5() {
		String inputString1 = "3 5 + 7 2 - *";
		calculator.processInput(inputString1);
		
		String output = outContent.toString().replaceAll("stack: ", "");
		assertThat("Expected the stack to be 40", output, containsString("40"));
	}
}

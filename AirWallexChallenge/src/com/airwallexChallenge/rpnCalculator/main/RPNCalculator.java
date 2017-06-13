package com.airwallexChallenge.rpnCalculator.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;

import com.airwallexChallenge.rpnCalculator.main.operators.IOperatorStrategy;
import com.airwallexChallenge.rpnCalculator.main.operators.OperatorEnum;
import com.airwallexChallenge.rpnCalculator.main.operators.SquareRoot;
import com.airwallexChallenge.rpnCalculator.main.operators.basic.Addition;
import com.airwallexChallenge.rpnCalculator.main.operators.basic.Division;
import com.airwallexChallenge.rpnCalculator.main.operators.basic.Multiplication;
import com.airwallexChallenge.rpnCalculator.main.operators.basic.Subtraction;
import com.airwallexChallenge.rpnCalculator.main.util.NumberUtils;

/**
 * The RPNCalculator.
 * <p>
 * This class provides the functionality of an RPN calculator that is wrapped
 * within the class. 
 * <p>
 * @author szeyick
 */
public class RPNCalculator {

	/**
	 * A queue that is used to represent the stack. Used to maintain the
	 * current values held by the calculator.
	 */
	private Deque<Double> currentStack;

	/**
	 * A queue that is used to represent the previous stack states that have been
	 * held by the calculator. Used to save the current state of the stack before a
	 * new operation is performed on it. Also used by the undo operation to restore previous
	 * stack states.
	 */
	private Deque<Deque<Double>> archivedStacks;

	/**
	 * A map of available operations that the calculator can process.
	 */
	private EnumMap<OperatorEnum, IOperatorStrategy> strategyMap;

	/**
	 * Constructor.
	 */
	public RPNCalculator() {
	    currentStack = new ArrayDeque<>();
		archivedStacks = new ArrayDeque<>();
		initStrategies();
	}

	/**
	 * Initialise the operator strategies that can be used by this
	 * calculator.
	 */
	private void initStrategies() {
		strategyMap = new EnumMap<>(OperatorEnum.class);
		strategyMap.put(OperatorEnum.ADD, new Addition());
		strategyMap.put(OperatorEnum.SUBTRACT, new Subtraction());
		strategyMap.put(OperatorEnum.MULTIPLY, new Multiplication());
		strategyMap.put(OperatorEnum.DIVIDE, new Division());
		strategyMap.put(OperatorEnum.SQUARE_ROOT, new SquareRoot());
		strategyMap.put(OperatorEnum.CLEAR, new Clear());
		strategyMap.put(OperatorEnum.UNDO, new Undo());
	}

	/**
	 * @param userInputString - The string containing the user input.
	 */
	public void processInput(String userInputString) {
		// The input string should be a space separated list of numbers and operators.
		String[] inputList = userInputString.split(" ");
		int space = 1; // Count removed spaces.
		for (int currentIndex = 0; currentIndex < inputList.length; currentIndex++) {
			String input = inputList[currentIndex];
			OperatorEnum operator = OperatorEnum.convertStringToOperator(input);
			if (!OperatorEnum.NOT_OPERATOR.equals(operator)) {
				if (!invokeOperator(currentIndex, operator, space, input)) {
					break;
				}
			}
			else if (NumberUtils.isNumericValue(input)) {
				invokeOperand(input);
			}
			space++;
		}
		printStackContents();
	}

	/**
	 * Push the operand onto the stack.
	 * @param input - The input value.
	 */
	private void invokeOperand(String input) {
		archiveCurrentStack();
		currentStack.addLast(Double.valueOf(input));
	}

	/**
	 * Perform an operation using the operators. Preserve the current state of the stack if the
	 * operator is not "undo".
	 * @param currentIndex - The current index in the input sequence.
	 * @param operator - The operator to perform.
	 * @param space - The white space counted.
	 * @param input - The current input value.
	 * @return <code>true</code> if the operation has been successfully performed, <code>false</code> otherwise
	 */
	private boolean invokeOperator(int currentIndex, OperatorEnum operator, int space, String input) {
		if (!OperatorEnum.UNDO.equals(operator)) {
			archiveCurrentStack();
		}

		IOperatorStrategy strategy = strategyMap.get(operator);
		boolean operationPerformed = strategy.performOperation(currentStack);
		if (!operationPerformed) {
			int index = currentIndex + space;
			System.out.println("operator " + input + " (position: " + index + "): insufficient parameters");
		}
		return operationPerformed;
	}

	/**
	 * Archive the contents of the current stack.
	 */
	private void archiveCurrentStack() {
	    Deque<Double> backup = new ArrayDeque<>();
	    for (Double value : currentStack) {
	        backup.addLast(value);
        }
		archivedStacks.addLast(backup);
	}

	/**
	 * Print the contents of the current stack.
	 */
	private void printStackContents() {
		System.out.print("stack: ");
		for (Double value : currentStack) {
		    String valueToPrint = NumberUtils.formatNumber(value);
            System.out.print(valueToPrint + " ");
		}
		System.out.println();
	}

	/**
	 * The Clear.
	 * <p>
	 * This class is responsible for performing a clear operation on the input stack. It is a
	 * private class within the calculator as it is a default operation.
	 * <p>
	 * <b>Warning: </b>None.
	 * <p>
	 * @author szeyick
	 */
	private class Clear implements IOperatorStrategy {

		/**
		 * @param valueStack - The input stack.
		 * @return <code>true</code> as the stack current stack can always be cleared.
		 */
		@Override
		public boolean performOperation(Deque<Double> valueStack) {
			valueStack.clear();
			return true;
		}
	}

	/**
	 * The Undo.
	 * <p>
	 * This class is responsible for performing an undo operation on the input stack. When invoked
	 * it will pop an available stack off the archive and setting it as the current stack. If the archive
	 * is empty, a new empty stack is returned.
	 * <p>
	 * <b>Warning: </b>None.
	 * <p>
	 * @author szeyick
	 */
	private class Undo implements IOperatorStrategy {

		/**
		 * @param valueStack - The input stack.
		 * @return <code>true</code> as a stack is always returned.
		 */
		@Override
		public boolean performOperation(Deque<Double> valueStack) {
			if (!archivedStacks.isEmpty()) {
				currentStack = archivedStacks.pollLast();
			}
			else {
				currentStack = new ArrayDeque<>();
			}
			return true;
		}
	}
}
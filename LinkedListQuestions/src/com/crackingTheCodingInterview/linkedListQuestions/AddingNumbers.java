package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.IntegerNode;

/**
 * The {@link AddingNumbers}.
 * <p>
 * You have two numbers represented by a linked list, where
 * each node contains a single digit. The digits are stored in 
 * reverse order, such that the 1's digit is at the head of the list.
 * <p>
 * Write a function that adds the two numbers together and returns
 * the sum of the linked list.
 * <p>
 * Example - <br>
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295 <br>
 * Output: 2 -> 1 -> 9. That is 912. <br>
 * <p>
 * Follow up - Suppose the digits are stored in forward order. Repeat
 * the above problem <br>
 * 
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is 617 + 295 <br>
 * Output: 9 -> 1 -> 2. That is 912. <br>
 * <p>
 * Solution:
 * Since the numbers are already in order, we will be able to iterate through
 * and add them up to create the updated linked list, however the trick here
 * is to then carry the remainder once it is greater than 10.
 * <p>
 * If the number are in forward order, we can reverse the linked list and then
 * perform the same addition as we did in the above solution. If the order has
 * to be kept, then you could push the values onto a stack to retrieve the result.
 * <p>
 * @author szeyick
 */
public class AddingNumbers {
	
	/**
	 * The program main
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[] value1 = new int[] {7, 1, 6};
		int[] value2 = new int[] {5, 9, 2};
		
		int[] value3 = new int[] {6, 1, 7};
		int[] value4 = new int[] {2, 9, 5};
		
		IntegerNode listValue1 = createList(value1);
		IntegerNode listValue2 = createList(value2);
		printReverseOrder(listValue1);
		System.out.print(" + ");
		printReverseOrder(listValue2);
		System.out.print(" = ");
		addValues(listValue1, listValue2);
		
		System.out.println();
		
		IntegerNode listValue3 = createList(value3);
		IntegerNode listValue4 = createList(value4);
		printList(listValue3);
		System.out.print(" + ");
		printList(listValue4);
		System.out.print(" = ");
		
		listValue3 = reverseLinkedList(listValue3);
		listValue4 = reverseLinkedList(listValue4);
		addValues(listValue3, listValue4);
	}
	
	/**
	 * Reverse the linked list so the tail becomes the head.
	 * @param list - The list to reverse.
	 * @return - A list of reversed entries.
	 */
	private static IntegerNode reverseLinkedList(IntegerNode list) {
		IntegerNode currentNode = list;
		IntegerNode previousNode = null;
		IntegerNode nextNode = null;
		
		// Reverse the pointers.
		while (currentNode != null) {
			nextNode = currentNode.nextNode; // Ensure we are always going forward.
			currentNode.nextNode = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			
		}
		return previousNode;
	}
	
	/**
	 * Add the values of two linked lists together where the numbers in the
	 * list are contained in backwards order (i.e 7-1-6 is 617).
	 * @param value1 - The list containing the first value.
	 * @param value2 - The list containing the second value.
	 */
	private static void addValues(IntegerNode value1, IntegerNode value2) {
		IntegerNode totalValue = null;
		IntegerNode currentValue1 = value1;
		IntegerNode currentValue2 = value2;
		int remainder = 0;
		int currentSum = 0;
		
		// Iterate through both lists.
		while (currentValue1 != null && currentValue2 != null) {
			currentSum = currentValue1.value + currentValue2.value + remainder;
			if (currentSum >= 10) {
				// Only store the remainder and carry the 1.
				totalValue = addValueToList(currentSum % 10, totalValue);
				remainder = 1;
			}
			else {
				totalValue = addValueToList(currentSum, totalValue);
				remainder = 0;
			}
			currentValue1 = currentValue1.nextNode;
			currentValue2 = currentValue2.nextNode;
		}
		// If one list is longer than the other we'll need to add the rest of the values.
		if (currentValue1 != null) {
			appendValuesToEnd(totalValue, currentValue1);
		}
		if (currentValue2 != null) {
			appendValuesToEnd(totalValue, currentValue2);
		}
		printReverseOrder(totalValue);
	}
	
	/**
	 * Append values to the end of the list.
	 * @param totalValue - Append values to the end of this node.
	 * @param valuesToAdd - The values to append.
	 */
	private static void appendValuesToEnd(IntegerNode totalValue, IntegerNode valuesToAdd) {
		while (valuesToAdd != null) {
			totalValue.add(valuesToAdd.value);
			valuesToAdd = valuesToAdd.nextNode;
		}
	}
	
	/**
	 * Create the start of a new list.
	 * @param value - The value to be at the head of the new list.
	 * @param node - The node containing the current value.
	 * @return - The new list with a single item.
	 */
	private static IntegerNode addValueToList(int value, IntegerNode totalValue) {
		if (totalValue == null) {
			totalValue = new IntegerNode(value);
		}
		else {
			totalValue.add(value);
		}
		return totalValue;
	}
	
	/**
	 * Print the reverse order of the list.
	 * @param list - The list to print the reverse order of.
	 */
	private static void printReverseOrder(IntegerNode list) {
		if (list == null) {
			return;
		}
		else {
			printReverseOrder(list.nextNode);
			System.out.print(list.value);
		}
	}
	
	/**
	 * Print the contents of the list.
	 * @param list - The list to print.
	 */
	private static void printList(IntegerNode list) {
		IntegerNode currentNode = list;
		while (currentNode != null) {
			System.out.print(currentNode.value);
			currentNode = currentNode.nextNode;
		}
	}

	/**
	 * Create the linked list with an array of values.
	 * @param values - The values to create the linked list.
	 */
	private static IntegerNode createList(int[] values) {
		IntegerNode list = null;
		for (int i = 0; i < values.length; i++) {
			if (list == null) {
				list = new IntegerNode(values[i]);
			}
			else {
				list.add(values[i]);
			}
		}
		return list;
	}
}

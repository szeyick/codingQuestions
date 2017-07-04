package com.crackingTheCodingInterview.bitManipulation;

import com.crackingTheCodingInterview.bitManipulation.examples.BinaryRepresentationLessThanOne;
import com.crackingTheCodingInterview.bitManipulation.examples.BitExamples;
import com.crackingTheCodingInterview.bitManipulation.examples.BitInsertion;
import com.crackingTheCodingInterview.bitManipulation.examples.NextLargestBit;

/**
 * The BitManipulationMain.
 * <p>
 * This main class is responsible for providing the application
 * entry point that will demonstrate various methods of manipulating
 * bits.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class BitManipulationMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		BinaryRepresentationLessThanOne.demo();
		BitInsertion.demo();
		NextLargestBit.demo();
		BitExamples.demo();
	}
}

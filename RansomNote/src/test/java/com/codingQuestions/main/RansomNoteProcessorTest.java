package com.codingQuestions.main;

import org.junit.Test;

/**
 * The RansomNoteProcessorTest.
 * <p>
 * This class is responsible for providing the test case to 
 * test the {@link RansomNoteProcessor}.
 * <p>
 * @author szeyick
 */
public class RansomNoteProcessorTest {

	/**
	 * Test the entries.
	 */
	@Test
	public void testValidNoteProcessor() {
		RansomNoteProcessor processor = new RansomNoteProcessor();

		String magazine = "give me one grand today night";
		String note = "give one grand today";

		System.out.println("Can ransom note be made: " + processor.canRansomNoteBeMade(magazine, note));
	}

	/**
	 * Test the entries in capitals.
	 */
	@Test
	public void testCapitalsNoteProcessor() {
		RansomNoteProcessor processor = new RansomNoteProcessor();

		String magazine = "GIVE ME ONE GRAND TONIGHT";
		String note = "GIVE ME ONE GRAND";

		System.out.println("Can ransom note be made: " + processor.canRansomNoteBeMade(magazine, note));
	}
	
	/**
	 * Test invalid entry.
	 */
	@Test
	public void testINValidNoteProcessor() {
		RansomNoteProcessor processor = new RansomNoteProcessor();

		String magazine = "YoU ShOuLd GimMe SoMe MoNiEs";
		String note = "Please I think you should give me something";

		System.out.println("Can ransom note be made: " + processor.canRansomNoteBeMade(magazine, note));
	}


}

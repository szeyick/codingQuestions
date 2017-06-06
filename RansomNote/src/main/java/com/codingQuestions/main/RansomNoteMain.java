package com.codingQuestions.main;

/**
 * The RansomNoteMain.
 * <p>
 * This class is responsible for providing a demonstration
 * of the ransom algorithm. It takes two strings, one for the magazine
 * and the other for the note. The processor then reads the input and upon
 * request can return whether the ransom note could be made from the magazine.
 * <p>
 * @author szeyick
 */
public class RansomNoteMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		RansomNoteProcessor processor = new RansomNoteProcessor();
		
		String magazine = "give me one grand today night";
		String note = "give one grand today";
		
		System.out.println("Can ransom note be made: " + processor.canRansomNoteBeMade(magazine, note));
	}
}

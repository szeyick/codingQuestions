package com.crackingTheCodingInterview.stringQuestions;

/**
 * The {@link StringCompression}.
 * <p>
 * Implement a method to perform basic string compression using
 * the counts of repeated characters. For example, the string
 * 'aabcccccaaa' would become 'a2b1c5a3. If the "compressed" string
 * would not be smaller than the original string, the method should
 * return the original string.
 * <p>
 * Solution - Character counting. <br>
 * - The solution could be to count forward and add to an additional array, when we
 *   get to the end, we compare the two strings to see which is bigger. <br>
 * - Write it to a custom string buffer which would reduce it to a O(nm) linear time
 *   algorithm rather than building a fixed size array to begin with. The m would be
 *   the maximum number of occurences that would occur for a single letter.
 * 
 * @author szeyick
 *
 */
public class StringCompression {

	/**
	 * The program main
	 * @param args - The command line arguments.
	 */
	public static void main(String[] args) {
		String inputString = "aabcccccaaa";
		compressString(inputString);;
	}

	/**
	 * Compress the string and output the result.
	 * @param inputString - The input string to compress.
	 */
	public static void compressString(String inputString) {
		CustomStringBuffer stringBuffer = new CustomStringBuffer();
		// Iterate through the input string and count occurences.
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			stringBuffer.addCharacter(c);
			
			// count occurences of the character.
			int j = i;
			int characterCount = 0;
			while ((j < inputString.length()) && (inputString.charAt(j) == c)) {
				characterCount++;
				j++;
			}
			stringBuffer.addCharacter((char) (48 + (char)characterCount));
			i = j - 1;
		}
		
		if (stringBuffer.getLength() < inputString.length()) {
			System.out.println(stringBuffer);
		}
		else {
			System.out.println(inputString);
		}
	}
	
	/**
	 * The {@link CustomStringBuffer} class.
	 * <p>
	 * This class acts as the string buffer to store
	 * the instances of a string before they are converted
	 * to a String. This reduces the number of String objects that
	 * are created since they are immutable.
	 * <p>
	 * <b>Warning: </b> This string buffer is currently not optimised to
	 * handle anything other than characters, nor will it resize when the 
	 * buffer is full. An addition would be that the stringBuffer is resized
	 * when it gets to full which is an array resizing operation. 
	 * <p>
	 * @author szeyick
	 */
	private static class CustomStringBuffer {
		
		/**
		 * The buffer of string characters
		 */
		private char[] stringBuffer;
		
		/**
		 * The index of the first available slot.
		 */
		private int currentIndex; 
		
		/**
		 * Constructor
		 */
		public CustomStringBuffer() {
			stringBuffer = new char[30];
			currentIndex = 0;
		}
		
		/**
		 * Add a character to the buffer.
		 * @param c
		 */
		public void addCharacter(char c) {
			stringBuffer[currentIndex] = c;
			currentIndex++;
		}
		
		/**
		 * @return - The current length of the string buffer.
		 */
		public int getLength() {
			return currentIndex;
		}
		
		/**
		 * Convert the stringBuffer contents to a string.
		 */
		@Override
		public String toString() {
			char[] completeString = new char[currentIndex + 1];
			for (int i = 0; i < currentIndex; i++) {
				completeString[i] = stringBuffer[i];
			}
			return String.valueOf(completeString);
		}
	}
}

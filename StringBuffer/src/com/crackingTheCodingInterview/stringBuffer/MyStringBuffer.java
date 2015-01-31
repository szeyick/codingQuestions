package com.crackingTheCodingInterview.stringBuffer;

/**
 * The {@link MyStringBuffer} class.
 * <p>
 * This class is a custom representation
 * of the functionality of the StringBuffer class. <p>
 * 
 * The StringBuffer adds all the Strings that it needs
 * to concatenate at some point into an array cache and
 * only when the toString() method is called is when it
 * does the copy of the characters into a new array object. <p>
 * 
 * By doing this, we reduce the number of additional strings that
 * are created and the copy operations to copy the characters across
 * into the new array into single operation.
 * 
 * @author szeyick
 *
 */
public class MyStringBuffer {

	/**
	 * The cache of available space in the buffer.
	 * This will need to be resized if the buffer gets full.
	 */
	private String[] stringCache;
	
	/**
	 * The total length of all characters in the buffer.
	 */
	private int length;
	
	/**
	 * The total size of the cache.
	 */
	private int cacheSize;
	
	/**
	 * Constructor to initialise values.
	 */
	public MyStringBuffer() {
		stringCache = new String[10];
		length = 0;
		cacheSize = 0;
	}
	
	/**
	 * Append a string to the cache.
	 * @param textString - The string to append.
	 */
	public void append(String textString) {
		if (cacheSize == (stringCache.length - 1)) {
			// Need to resize the array if we max out the buffer
			resizeCache();
		}
		stringCache[cacheSize] = textString;
		cacheSize++;
		length += textString.length();
	}
	
	/**
	 * Copy the current elements into a new array
	 * since we have reached capacity.
	 */
	private void resizeCache() {
		String[] newCache = new String[stringCache.length * 2];
		for (int i = 0; i < stringCache.length; i++) {
			newCache[i] = stringCache[i];
		}
		stringCache = newCache;
	}
	
	/**
	 * @return - The concatenated string upon.
	 */
	@Override
	public String toString() {
		char[] concatenatedString = new char[length];
		int currentIndex = 0;
		for (int i = 0; i < cacheSize; i++) {
			String word = stringCache[i];
			int wordLength = word.length();
			for (int j = 0; j < wordLength; j++) {
				concatenatedString[currentIndex] = word.charAt(j);
				currentIndex++;
			}
		}
		return new String(concatenatedString);
	}
}

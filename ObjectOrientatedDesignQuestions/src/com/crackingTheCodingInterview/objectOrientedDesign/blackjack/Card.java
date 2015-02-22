package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

/**
 * The {@link Card}
 * <p>
 * This class represents an individual card.
 * <p>
 * @author szeyick
 */
public class Card {

	/**
	 * The suite for the card.
	 */
	private Suite suite;
	
	/**
	 * The value of the card. The value
	 * is from ace -> king.
	 */
	private int value;
	
	/**
	 * Constructor.
	 * @param suiteTmp - The suite for the card.
	 * @param valueTmp - The value for the card.
	 */
	public Card(Suite suiteTmp, int valueTmp) {
		suite = suiteTmp;
		value = valueTmp;
	}
	
	/**
	 * @return - The suite assigned to the card.
	 */
	public Suite getSuite() {
		return suite;
	}
	
	/**
	 * @return - The value of the card.
	 */
	public int getValue() {
		return value;
	}
}

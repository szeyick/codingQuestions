package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The {@link Deck}.
 * <p>
 * This class represents a deck of cards. A standard deck
 * is comprised of 52 cards. A deck also has operations that
 * it can perform which is defined in the blackjack read me
 * file.
 * <p> 
 * @author szeyick
 */
public class Deck {

	/**
	 * The list representing a deck of cards.
	 */
	private List<Card> deck;
	
	/**
	 * A collection of the cards that have currently
	 * been dealt out.
	 */
	private Map<Card, Card> dealtOutCards;
	
	/**
	 * Constructor.
	 */
	public Deck() {
		deck = new ArrayList<Card>();
		dealtOutCards = new HashMap<Card, Card>();
		initDeck();
	}
	
	/**
	 * Create all the cards required by the deck.
	 */
	private void initDeck() {
		// Iterate through the suite to create the cards.
		for (Suite suite : Suite.values()) {
			// For each suite, create the cards 1 -> 13 (Ace -> King)
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(suite, i);
				deck.add(card);
			}
		}
	}
	
	/**
	 * Print the cards that are in the deck.
	 */
	public void printDeck() {
		for (Card card : deck) {
			System.out.println(card.getSuite() + " : " + card.getValue());
		}
	}
	
	/**
	 * Deal or remove a card from the deck.
	 * @return The card to remove from the deck.
	 */
	public Card dealCard() {
		// If the deck is empty, all cards have been dealt.
		if (deck.isEmpty()) {
			return null;
		}
		
		// Remove a random card from the deck.
		Random r = new Random();
		int low = 0;
		int high = deck.size();
		int cardIndex = r.nextInt(high - low) + low;
		
		Card card = deck.remove(cardIndex);
		
		// Register that the card has been removed from the deck.
		dealtOutCards.put(card, card); 
		return card;
	}
	
	/**
	 * Place a card back into the deck.
	 * @param card - The card to put back.
	 */
	public boolean replaceCard(Card card) {
		if (dealtOutCards.containsKey(card)) {
			dealtOutCards.remove(card);
			deck.add(card);
			return true;
		}
		return false;
	}
	
	/**
	 * Shuffle the deck of cards.
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}

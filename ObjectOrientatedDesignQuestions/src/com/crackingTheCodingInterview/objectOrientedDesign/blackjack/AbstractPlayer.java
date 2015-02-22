package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link AbstractPlayer}
 * <p>
 * This class is an abstract representation of
 * a player. In a blackjack game, a player and dealer
 * can play the game and share common actions.
 * <p>
 * @author szeyick
 */
public abstract class AbstractPlayer {

	/**
	 * The name of the player.
	 */
	protected String playerName;
	
	/**
	 * The current hand the player has.
	 */
	protected List<Card> currentHand;
	
	/**
	 * Is the current hand a bust.
	 */
	protected boolean isBust;
	
	/**
	 * Abstract constructor.
	 */
	public AbstractPlayer(String name) {
		currentHand = new ArrayList<Card>();
		isBust = false;
		playerName = name;
	}
	
	/**
	 * The method invoked when a player/dealer plays
	 * a hand.
	 */
	public abstract void playHand(AbstractPlayer dealer);
	
	/**
	 * @return
	 */
	public int calculateTotal() {
		int handTotal = 0;
		for (Card card : currentHand) {
			handTotal += card.getValue();
		}
		return handTotal;
	}
	
	/**
	 * @return - The cards to be put back into the deck.
	 */
	protected List<Card> returnCards() {
		return currentHand;
	}
}

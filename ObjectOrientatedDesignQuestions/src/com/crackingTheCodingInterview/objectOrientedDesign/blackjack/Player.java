package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

public class Player extends AbstractPlayer {

	/**
	 * Constructor. 
	 * @param name - The name for the player
	 */
	public Player(String name) {
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void playHand(AbstractPlayer dealer) {
		// Keep on requesting cards to get as close to 21 as we can.
		// If this was a real game, you'd give the player the option 
		// to hit/stay.
		int currentTotal = calculateTotal();
		while (currentTotal < 21) {
			Card currentCard = ((Dealer)dealer).dealCard();
			currentHand.add(currentCard);
			currentTotal += currentCard.getValue();
		}
		// Bust if total is larger than 21.
		if (currentTotal > 21) {
			isBust = true;
		}
	}
}

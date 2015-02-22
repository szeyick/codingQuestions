package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Dealer}
 * <p>
 * This class represents the dealer in a game of
 * blackjack. It manages the deck of cards and also
 * deals cards to the player.
 * <p>
 * @author szeyick
 */
public class Dealer extends AbstractPlayer {

	/**
	 * The deck of cards.
	 */
	private Deck deck;
	
	/**
	 * The players that are currently playing the game.
	 */
	private List<Player> players;
	
	/**
	 * Constructor.
	 */
	public Dealer(String name) {
		super(name);
		deck = new Deck();
		players = new ArrayList<Player>();
	}

	/**
	 * Start the game, this deals the initial
	 * cards to the players and dealer.
	 */
	public void startGame() {
		this.currentHand.add(deck.dealCard());
		this.currentHand.add(deck.dealCard());
		
		// Deal 2 cards to all players to begin the game.
		for (Player player : players) {
			player.currentHand.add(deck.dealCard());
			player.currentHand.add(deck.dealCard());
		}
	}
	
	/**
	 * Register a player with the dealer. It acts as a
	 * player sitting at the table.
	 * @param player - The player to play.
	 */
	public void registerPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void playHand(AbstractPlayer dealer) {
		// Keep on requesting cards to get as close to 21 as we can.
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
	
	/**
	 * @return - a card from the deck.
	 */
	public Card dealCard() {
		return deck.dealCard();
	}
	
	/**
	 * Reset the game.
	 */
	public void resetGame() {
		// Retrieve all the cards back from the players.
		for (Player player : players) {
			List<Card> playerHands = player.returnCards();
			for (Card card : playerHands) {
				deck.replaceCard(card);
			}
		}
	}
}

package com.crackingTheCodingInterview.objectOrientedDesign.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Blackjack}
 * <p>
 * This class represents the program main
 * for a game of blackjack. It is responsible for
 * creating the dealer and players, initialising
 * the game and passing control to the players involved
 * to attempt to get to 21.
 * <p>
 * @author szeyick
 */
public class Blackjack {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		List<AbstractPlayer> allPlayers = new ArrayList<AbstractPlayer>();
		
		Dealer dealer = new Dealer("Dealer");
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");

		dealer.registerPlayer(player1);
		dealer.registerPlayer(player2);
		
		allPlayers.add(dealer);
		allPlayers.add(player1);
		allPlayers.add(player2);
		
		boolean gameActive = true;
		
		// While the game still wants to be played.
		while (gameActive) { 
			dealer.startGame();
			for (AbstractPlayer player : allPlayers) {
				player.playHand(dealer);
			}
			findWinner(allPlayers);
			dealer.resetGame();
			gameActive = false;
		}
	}
	
	/**
	 * Find a winner in the game if one is available.
	 * @param allPlayers - All the players involved in the game.
	 */
	private static void findWinner(List<AbstractPlayer> allPlayers) {
		AbstractPlayer winningPlayer = null;
		int highestTotal = 0;
		for (AbstractPlayer player : allPlayers) {
			if (!player.isBust) {
				int playerTotal = player.calculateTotal();
				if (playerTotal >= highestTotal) {
					highestTotal = playerTotal;
					winningPlayer = player;
					// If the winner is the dealer, everyone loses.
					if (winningPlayer instanceof Dealer) {
						break;
					}
				}
			}
		}
		// The closest player to 21 wins.
		if (winningPlayer != null) {
			System.out.println("The winner of this round is - " + winningPlayer.playerName + " with total - " + winningPlayer.calculateTotal());
			System.out.println("All scores:");
			for (AbstractPlayer player : allPlayers) {
				System.out.println(player.playerName + " got " + player.calculateTotal());
			}
		}
		else {
			System.out.println("Everyone busted: Noone wins");
			for (AbstractPlayer player : allPlayers) {
				System.out.println(player.playerName + " got " + player.calculateTotal());
			}
		}
	}

}

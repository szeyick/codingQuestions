package com.codingquestions.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The InflightEntertainment.
 * <p>
 * This class is responsible for wrapping the
 * solution for the inflight entertainment coding
 * question.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class InflightEntertainment {

	/**
	 * The naive solution to the inflight entertainment. It uses two loops
	 * to find whether a movie has another movie that equals the flight length.
	 * <p>
	 * @param flightLength - The length of the flight.
	 * @param movieLengths - An array of movies lengths.
	 * @return <code>true</code> if there is a complimentary movie, <code>false</code>
	 * otherwise.
	 */
	public boolean naiveSolution(int flightLength, int[] movieLengths) {
		boolean found = false;
		for (int i = 0; i < movieLengths.length; i++) {
			int currentMovieLength = movieLengths[i];
			int movieLengthToFind = flightLength - currentMovieLength;
			for (int j = i + 1; j < movieLengths.length; j++) {
				int nextMovieLength = movieLengths[j];
				if (movieLengthToFind == nextMovieLength) {
					found = true;
					break;
				}
			}
		}
		return found;
	}

	/**
	 * The medium solution to the inflight entertainment. It uses a binary search
	 * to find whether a movie has another movie that equals the flight length.
	 * <p>
	 * @param flightLength - The length of the flight.
	 * @param movieLengths - An array of movies lengths.
	 * @return <code>true</code> if there is a complimentary movie, <code>false</code>
	 * otherwise. */
	public boolean mediumSolution(int flightLength, int[] movieLengths) {
		boolean found = false;
		Arrays.sort(movieLengths);
		for (int i = 0; i < movieLengths.length; i++) {
			int currentMovieLength = movieLengths[i];
			int movieLengthToFind = flightLength - currentMovieLength;
			int foundIndex = Arrays.binarySearch(movieLengths, i + 1, movieLengths.length, movieLengthToFind);
			if (foundIndex >= 0 && foundIndex < movieLengths.length && movieLengths[foundIndex] == movieLengthToFind) {
				found = true;
				break;
			}
		}
		return found;
	}

	/**
	 * The optimal solution to the inflight entertainment. It uses a hash set to
	 * store the movies that we have already seen, and uses the compliment to look
	 * up into the hashset to see if there is another movie that equals the flight
	 * length.
	 * <p>
	 * @param flightLength - The length of the flight.
	 * @param movieLengths - An array of movies lengths.
	 * @return <code>true</code> if there is a complimentary movie, <code>false</code>
	 * otherwise.
	 */
	public boolean optimalSolution(int flightLength, int[] movieLengths) {
		boolean found = false;
		Set<Integer> seenMovieSet = new HashSet<>();
		for (int i = 0; i < movieLengths.length; i++) {
			int currentMovieTime = movieLengths[i];
			int movieLengthToFind = flightLength - currentMovieTime;
			if (seenMovieSet.contains(movieLengthToFind)) {
				found = true;
				break;
			}
			seenMovieSet.add(currentMovieTime);
		}
		return found;
	}
}

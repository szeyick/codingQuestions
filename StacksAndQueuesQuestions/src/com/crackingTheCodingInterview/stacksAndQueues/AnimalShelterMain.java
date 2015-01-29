package com.crackingTheCodingInterview.stacksAndQueues;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crackingTheCodingInterview.stacksAndQueues.animalShelter.AnimalShelter;
import com.crackingTheCodingInterview.stacksAndQueues.animalShelter.IPet;
import com.crackingTheCodingInterview.stacksAndQueues.animalShelter.PetType;

/**
 * The {@link AnimalShelterMain}
 * <p>
 * An animal shelter holds only dogs and cats, and operates strictly
 * on a "first in, first out" basis. People must adopt either the "oldest"
 * (based on arrival time) of all animals at the shelter, or they can select whether
 * they would prefer a dog or cat (and will receive the oldest animal of that type). They 
 * cannot select which specific animal they would like. Create the data structures to maintain
 * this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. 
 * <br>
 * You may use the built-in LinkedList data structure.
 * <p>
 * Solution - <br>
 * The solution for this problem is to just use a queue. Animals that are inserted into the queue
 * in the order will automatically be in the order they should come out. Using the internal LinkedList
 * structure we will always append to the end and remove from the front.
 * <p>
 * @author szeyick
 */
public class AnimalShelterMain {

	/**
	 * The program main.
	 * @param args - The command line arguments.
	 */
	public static void main(String[] args) {
		AnimalShelter animalShelter = new AnimalShelter();
		initialiseShelter(animalShelter);
		animalShelter.totalAnimals();
		
		// Dequeue any pet from the shelter.
		printInfo(animalShelter.dequeueAny());
		animalShelter.totalAnimals();
		
		printInfo(animalShelter.dequeueDog());
		animalShelter.totalDogs();
		
		animalShelter.dequeueAll();
		printInfo(animalShelter.dequeueCat());
	}
	
	/**
	 * Initialise animals at the shelter.
	 * @param animalShelter - The animal shelter.
	 */
	private static void initialiseShelter(AnimalShelter animalShelter) {
		animalShelter.enqueue("Tim", PetType.DOG);
		animalShelter.enqueue("Jerry", PetType.DOG);
		animalShelter.enqueue("Mark", PetType.CAT);
		animalShelter.enqueue("Bob", PetType.CAT);
		animalShelter.enqueue("Daphney", PetType.DOG);
		animalShelter.enqueue("Julie", PetType.CAT);
		animalShelter.enqueue("Stuart", PetType.DOG);
		animalShelter.enqueue("Gerald", PetType.CAT);
		animalShelter.enqueue("Dianne", PetType.CAT);
	}
	
	/**
	 * Print the information regarding the pet.
	 * @param pet - The pet to output information.
	 */
	private static void printInfo(IPet pet) {
		if (pet == null) {
			System.out.println("Sorry no more pets at the shelter");
		}
		else {
			System.out.println("Adopted Pet");
			System.out.println("Name: " + pet.petName());
			System.out.println("Type: " + pet.getPetType());
			printDate(pet.dateReceived());
		}
	}
	
	/**
	 * Print the current date in the provided format.
	 */
	private static void printDate(Date time) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(dateFormat.format(time)); //2014/08/06 16:00:22
		System.out.println();
	}
}

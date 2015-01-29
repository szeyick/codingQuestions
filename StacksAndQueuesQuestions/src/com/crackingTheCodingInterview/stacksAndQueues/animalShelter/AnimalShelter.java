package com.crackingTheCodingInterview.stacksAndQueues.animalShelter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The {@link AnimalShelter}.
 * <p>
 * This animal shelter class is responsible for managing pet adoption
 * of either cats or dogs. The shelter provides cats or dogs to people 
 * who want to adopt them and has operations to enqueue, dequeueAny, dequeueDog
 * and dequeueCat.
 * <p>
 * @author szeyick
 */
public class AnimalShelter {

	/**
	 * The dog queue.
	 */
	private List<IPet> dogQueue;
	
	/**
	 * The cat queue.
	 */
	private List<IPet> catQueue;
	
	/**
	 * Constructor.
	 */
	public AnimalShelter() {
		dogQueue = new LinkedList<IPet>();
		catQueue = new LinkedList<IPet>();
	}
	
	/**
	 * Add an animal to the shelter.
	 * <br>
	 * Since we are using the internal LinkedList structure we
	 * can use the internal methods to automatically add to the 
	 * end of the LinkedList which simulates adding to a queue.
	 */
	public void enqueue(String petName, PetType petType) {
		Pet newPet = new Pet(petName, petType);
		if (PetType.DOG.equals(petType)) {
			dogQueue.add(newPet);
		}
		else {
			catQueue.add(newPet);
		}
	}
	
	/**
	 * @return - Any pet from either queue, <code>null</code> if
	 * the shelter has no more pets. Internal struture allows us to
	 * remove from the head (index 0) of either queue. We need to 
	 * call remove rather than get since we are dequeuing the animal
	 * which is to remove from the queue.
	 */
	public IPet dequeueAny() {
		int value = generateRandomNumber();
		IPet pet = null;
		if (value == 1) {
			if (!dogQueue.isEmpty()) {
				pet = dogQueue.remove(0);
			}
		}
		else {
			if (!catQueue.isEmpty()) {
				pet = catQueue.remove(0);
			}
		}
		return pet;
	}
	
	/**
	 * @return - the "oldest" cat at the
	 * shelter. If the cat queue is empty then we return
	 * null, otherwise we return the cat at the first index.
	 */
	public IPet dequeueCat() {
		return !catQueue.isEmpty()? catQueue.remove(0) : null;
	}
	
	/**
	 * @return - The "oldest" dog at the shelter. If the dog
	 * queue is empty we return null otherwise we return the dog
	 * at the first index.
	 */
	public IPet dequeueDog() {
		return !dogQueue.isEmpty()? dogQueue.remove(0) : null;
	}
	
	/**
	 * Release all the animals from the shelter.
	 */
	public void dequeueAll() {
		dogQueue.clear();
		catQueue.clear();
	}
	
	/**
	 * Print the total number of animals at the shelter.
	 */
	public void totalAnimals() {
		System.out.println("Total Number of Animals at the Shelter - ");
		totalDogs();
		totalCats();
		System.out.println();
	}
	
	/**
	 * Print the total number of dogs at the shelter.
	 */
	public void totalDogs() {
		System.out.println("Total Dogs - " + dogQueue.size());
	}
	
	/**
	 * Print the total number of cats at the shelter.
	 */
	public void totalCats() {
		System.out.println("Total Cats - " + catQueue.size());
	}
	
	/**
	 * The {@link Pet}.
	 * <p>
	 * This class represents the pets that are at
	 * the animal shelter. Each pet that comes into the
	 * shelter is of this type.
	 * <p>
	 * @author szeyick
	 */
	private class Pet implements IPet {

		/**
		 * The name of the pet.
		 */
		private String petName;
		
		/**
		 * The type of pet.
		 */
		private PetType petType;
		
		/**
		 * The date the pet arrived.
		 */
		private Date dateReceived;
		
		/**
		 * Constructor.
		 */
		public Pet(String petNameTmp, PetType petTypeTmp) {
			petName = petNameTmp;
			petType = petTypeTmp;
			dateReceived = getCurrentDate();
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public String petName() {
			return petName;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Date dateReceived() {
			return dateReceived;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public PetType getPetType() {
			return petType;
		}
	}

	/**
	 * @return - The current date.
	 */
	private Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * @return a randomly generated number between
	 * low and high ranges.
	 */
	private static int generateRandomNumber() {
		Random r = new Random();
		int low = 0;
		int high = 1;
		return r.nextInt(high-low) + low;
	}
}

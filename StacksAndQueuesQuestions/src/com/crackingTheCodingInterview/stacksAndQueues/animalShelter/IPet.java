package com.crackingTheCodingInterview.stacksAndQueues.animalShelter;

import java.util.Date;

/**
 * The {@link IPet}.
 * <p>
 * This interface provides external access
 * to methods without divulging the internal
 * workings of the class.
 * <p>
 * @author szeyick
 */
public interface IPet {

	/**
	 * @return - The name of the pet.
	 */
	public String petName();
	
	/**
	 * @return - The date that the pet came into the
	 * shelter.
	 */
	public Date dateReceived();
	
	/**
	 * @return - The type of pet that it is.
	 */
	public PetType getPetType();
}

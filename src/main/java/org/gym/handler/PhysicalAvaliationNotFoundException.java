package org.gym.handler;

public class PhysicalAvaliationNotFoundException
	  extends Exception {
	public PhysicalAvaliationNotFoundException(Long avaliationId)  {
		super("Avaliation not found for id: " + avaliationId);
	}
}

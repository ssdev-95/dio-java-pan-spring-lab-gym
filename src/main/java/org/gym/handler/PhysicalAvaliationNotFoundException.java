package org.gym.handler;

public class PhysicalAvaliationNotFoundException
	  extends RuntimeException {
	public PhysicalAvaliationNotFoundException(Long avaliationId)  {
		super("Avaliation not found for id: " + avaliationId);
	}
}

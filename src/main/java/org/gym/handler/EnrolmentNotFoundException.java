package org.gym.handler;

public class EnrolmentNotFoundException extends RuntimeException {
	public EnrolmentNotFoundException(Long enrolmentId)  {
		super("Enrolment not found for id: " + enrolmentId);
	}
}

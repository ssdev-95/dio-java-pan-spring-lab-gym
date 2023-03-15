package org.gym.handler;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(Long studentId)  {
		super("Student not found for id: " + studentId);
	}
}

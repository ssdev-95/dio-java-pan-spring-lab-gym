package org.gym.handler;

public class StudentNotFoundException extends Exception {
	public StudentNotFoundException(Long studentId)  {
		super("Student not found for id: " + studentId);
	}
}

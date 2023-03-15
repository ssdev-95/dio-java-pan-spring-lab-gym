package org.gym.service;

import java.time.LocalDate;

import org.aspectj.lang.annotation.Before;

import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.handler.StudentNotFoundException;
import org.gym.repository.StudentsRepository;
import org.gym.service.impl.StudentService;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.mockito.Mock;
import org.mockito.InjectMocks;

@TestInstance( value = Lifecycle.PER_CLASS)
public class StudentServiceTests {
	@Mock
	private static StudentsRepository repository;
	@InjectMocks
	private static StudentService service;

	@BeforeAll
	static void setup() {
		service = new StudentService(repository);
	}

	@Test
	void GetStudentMustThrowAnException() {
		Assertions.assertThrows(
				StudentNotFoundException.class, ()->service.get(1l));
	}

	@Test
	void shouldCreateAStudent() {
		LocalDate dateBirth = LocalDate.parse("2023-08-18");
		StudentCreateForm form = new StudentCreateForm(
				"Saloma", "Long Island", 28472818273473l, dateBirth);
		service.create(form);
		Assertions.assertEquals(1l, repository.count());
	}

	@AfterAll
	void drop() {
		service = null;
	}
}

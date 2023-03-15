package org.gym.controller;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;
import org.gym.handler.StudentNotFoundException;
import org.gym.service.impl.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService service;

	public StudentController(final StudentService service) {
		this.service = service;
	}

	@PostMapping
	public Student create(@RequestBody StudentCreateForm form) {
		return service.create(form);
	}

	@GetMapping
	public List<Student> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(service.get(id));
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/avaliations")
	public ResponseEntity<Object> getAllAvaliationByStudentId(
			@RequestParam Long id) {
		try {
			List<PhysicalAvaliation> avaliations = service
				.getAllAvaliationByStudentId(id);
			return ResponseEntity.ok(avaliations);
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping()
	public ResponseEntity<Object> update(
			@RequestParam Long id, @RequestBody StudentUpdateForm form) {
		try {
			return ResponseEntity.ok(service.update(id, form));
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@RequestParam Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(null);
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}
}

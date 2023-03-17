package org.gym.controller;

import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.form.EnrolmentForm;
import org.gym.handler.EnrolmentNotFoundException;
import org.gym.handler.StudentNotFoundException;
import org.gym.service.impl.EnrolmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrolments")
public class EnrolmentController {
	private final EnrolmentService service;

	public EnrolmentController(final EnrolmentService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Object> enrol(
			@RequestBody EnrolmentForm form) {
		try {
			return ResponseEntity.ok(service.create(form));
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{neighbor}")
	public List<Enrolment> getAll(@RequestParam String neighbor) {
		return service.getAll(neighbor);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(service.get(id));
		} catch(EnrolmentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@RequestParam Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(null);
		} catch(EnrolmentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}
}

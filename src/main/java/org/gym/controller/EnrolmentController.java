package org.gym.controller;

import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.form.EnrolmentForm;
import org.gym.service.impl.EnrolmentService;
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
	public Enrolment enrol(@RequestBody EnrolmentForm form) {
		return this.service.create(form);
	}

	@GetMapping("/{neighbor}")
	public List<Enrolment> getAll(@RequestParam String neighbor) {
		return service.getAll(neighbor);
	}

	@GetMapping("/{id}")
	public Enrolment get(@RequestParam Long id) {
		return service.get(id);
	}


	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		service.delete(id);
	}
}

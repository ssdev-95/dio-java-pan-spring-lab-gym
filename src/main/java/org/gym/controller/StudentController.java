package org.gym.controller;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;
import org.gym.service.impl.StudentService;
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
	public Student get(@RequestParam Long id) {
		return service.get(id);
	}

	@GetMapping("/{id}/avaliations")
	public List<PhysicalAvaliation> getAllAvaliationByStudentId(
			@RequestParam Long id) {
		return service.getAllAvaliationByStudentId(id);
	}

	@PatchMapping()
	public Student update(
			@RequestParam Long id, @RequestBody StudentUpdateForm form) {
		return service.update(id, form);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		service.delete(id);
	}
}

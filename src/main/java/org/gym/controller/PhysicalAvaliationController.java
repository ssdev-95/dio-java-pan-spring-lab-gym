package org.gym.controller;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.form.PhysicalAvaliationForm;
import org.gym.entity.form.PhysicalAvaliationUpdateForm;
import org.gym.service.impl.PhysicalAvaliationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliations")
public class PhysicalAvaliationController {
	private final PhysicalAvaliationService service;

	public PhysicalAvaliationController(
			final PhysicalAvaliationService service) {
		this.service = service;
	}

	@PostMapping
	public PhysicalAvaliation avaliate(
			PhysicalAvaliationForm form) {
		return null;
	}

	@GetMapping
	public List<PhysicalAvaliation> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public PhysicalAvaliation get(@RequestParam Long id) {
		return service.get(id);
	}

	@PatchMapping("/{id}")
	public PhysicalAvaliation update(
			@RequestParam Long id,
			@RequestBody PhysicalAvaliationUpdateForm form) {
		return service.update(id, form);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		service.delete(id);
	}
}

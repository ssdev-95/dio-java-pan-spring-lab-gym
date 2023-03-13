package org.gym.service.impl;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.PhysicalAvaliationForm;
import org.gym.entity.form.PhysicalAvaliationUpdateForm;
import org.gym.repository.PhysicalAvaliationsRepository;
import org.gym.repository.StudentsRepository;
import org.gym.service.IPhysicalAvaliationService;
import org.springframework.stereotype.Service;

@Service
public class PhysicalAvaliationService
	  implements IPhysicalAvaliationService {
	private final PhysicalAvaliationsRepository repository;
	private final StudentsRepository stRepository;

	public PhysicalAvaliationService(
			final PhysicalAvaliationsRepository repository,
			final StudentsRepository stRepository) {
		this.repository = repository;
		this.stRepository = stRepository;
	}

	@Override
	public PhysicalAvaliation create(PhysicalAvaliationForm form) {
		Student student = stRepository
			.findById(form.getStudentId()).get();
		PhysicalAvaliation avaliation = new PhysicalAvaliation();
		avaliation.setWeight(form.getWeight());
		avaliation.setHeight(form.getHeight());
		avaliation.setStudent(student);
		return repository.save(avaliation);
	}

	@Override
	public PhysicalAvaliation get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<PhysicalAvaliation> getAll() {
		return repository.findAll();
	}

	@Override
	public PhysicalAvaliation update(
		Long id, PhysicalAvaliationUpdateForm form) { return null; }

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

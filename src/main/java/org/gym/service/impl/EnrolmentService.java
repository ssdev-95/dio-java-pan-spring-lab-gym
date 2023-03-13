package org.gym.service.impl;

import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.form.EnrolmentForm;
import org.gym.repository.EnrolmentsRepository;
import org.gym.service.IEnrolmentService;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService implements IEnrolmentService {
	private final EnrolmentsRepository repository;

	public EnrolmentService(
			final EnrolmentsRepository repository) {
		this.repository = repository;
	}

	@Override
	public Enrolment create(EnrolmentForm form) {
		Enrolment enrolment = new Enrolment();
		return repository.save(enrolment);
	}

	@Override
	public Enrolment get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Enrolment> getAll(String neighborhood) {
		//TODO: Must implements
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

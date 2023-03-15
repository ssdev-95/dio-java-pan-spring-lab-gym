package org.gym.service.impl;
	
import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.Student;
import org.gym.entity.form.EnrolmentForm;
import org.gym.handler.EnrolmentNotFoundException;
import org.gym.handler.StudentNotFoundException;
import org.gym.repository.EnrolmentsRepository;
import org.gym.repository.StudentsRepository;
import org.gym.service.IEnrolmentService;

import org.springframework.stereotype.Service;

@Service
public class EnrolmentService implements IEnrolmentService {
	private final EnrolmentsRepository repository;
	private final StudentsRepository stRepository;

	public EnrolmentService(
			final EnrolmentsRepository repository,
			final StudentsRepository stRepository) {
		this.repository = repository;
		this.stRepository = stRepository;
	}

	@Override
	public Enrolment create(EnrolmentForm form)
		  throws StudentNotFoundException {
		Student student = stRepository
			.findById(form.getStudentId())
			.orElseThrow(
				() -> new StudentNotFoundException(form.getStudentId()));
		Enrolment enrolment = new Enrolment();
		enrolment.setStudent(student);
		return repository.save(enrolment);
	}

	@Override
	public Enrolment get(Long id)
		  throws EnrolmentNotFoundException {
	  return repository.findById(id)
			.orElseThrow(() -> new EnrolmentNotFoundException(id));
	}

	@Override
	public List<Enrolment> getAll(String neighbor) {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) throws EnrolmentNotFoundException {
		repository.findById(id).orElseThrow(
				() -> new EnrolmentNotFoundException(id));
		repository.deleteById(id);
	}
}

package org.gym.service.impl;

import java.util.List;
import java.util.Optional;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;
import org.gym.handler.StudentNotFoundException;
import org.gym.repository.StudentsRepository;
import org.gym.service.IStudentService;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
	private final StudentsRepository repository;

	public StudentService(final StudentsRepository repository) {
		this.repository = repository;
	}

	@Override
	public Student create(StudentCreateForm form) {
		Student student = new Student();
		student.setName(form.getName());
		student.setCpf(form.getCpf());
		student.setNeighborhood(form.getNeighborhood());
		student.setBirthDate(form.getBirthDate());
		return repository.save(student);
	}

	@Override
	public Student get(Long id) throws StudentNotFoundException {
		Optional<Student> student = repository.findById(id);

		if(!student.isPresent()) {
			throw new StudentNotFoundException(id);
		}

		return student.get();
	}

	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	@Override
	public List<PhysicalAvaliation> getAllAvaliationByStudentId(
			Long id) throws StudentNotFoundException {
		Optional<Student> student = repository.findById(id);
		
		if(!student.isPresent())
			throw new StudentNotFoundException(id);

		return student.get().getAvaliations();
	}

	@Override
	public Student update(Long id, StudentUpdateForm form)
  	  throws StudentNotFoundException {
		Optional<Student> optional = repository.findById(id);

		if(!optional.isPresent())
			throw new StudentNotFoundException(id);

		Student student = optional.get();
		student.setId(id);
		student.setName(form.getName());
		student.setBirthDate(form.getBirthDate());
		student.setNeighborhood(form.getNeighborhood());
		return repository.saveAndFlush(student);
	}

	@Override
	public void delete(Long id) throws StudentNotFoundException {
		Optional<Student> student = repository.findById(id);

		if(!student.isPresent())
			throw new StudentNotFoundException(id);

		repository.deleteById(id);
	}
}

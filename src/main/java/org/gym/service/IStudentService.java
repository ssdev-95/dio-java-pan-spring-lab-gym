package org.gym.service;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;
import org.gym.handler.StudentNotFoundException;

public interface IStudentService {
	Student create(StudentCreateForm createForm);

	Student get(Long id) throws StudentNotFoundException;

	List<Student> getAll();

	Student update(Long id, StudentUpdateForm formUpdate)
		throws StudentNotFoundException;

	void delete(Long id) throws StudentNotFoundException;

	List<PhysicalAvaliation> getAllAvaliationByStudentId(Long id)
		throws StudentNotFoundException;
}

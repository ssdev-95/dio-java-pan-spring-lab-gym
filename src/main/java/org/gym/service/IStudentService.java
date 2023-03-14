package org.gym.service;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;

public interface IStudentService {
	Student create(StudentCreateForm createForm);

	Student get(Long id);

	List<Student> getAll();

	Student update(Long id, StudentUpdateForm formUpdate);

	void delete(Long id);

	List<PhysicalAvaliation> getAllAvaliationByStudentId(Long id);
}

package org.gym.service;

import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.form.EnrolmentForm;
import org.gym.handler.EnrolmentNotFoundException;
import org.gym.handler.StudentNotFoundException;

public interface IEnrolmentService {
	Enrolment create(EnrolmentForm form)
			throws StudentNotFoundException;

	Enrolment get(Long id) throws EnrolmentNotFoundException;

	List<Enrolment> getAll(String neighbor);

	void delete(Long id) throws EnrolmentNotFoundException;
}

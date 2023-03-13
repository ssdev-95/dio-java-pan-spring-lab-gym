package org.gym.service;

import java.util.List;

import org.gym.entity.Enrolment;
import org.gym.entity.form.EnrolmentForm;

public interface IEnrolmentService {
	Enrolment create(EnrolmentForm form);

	Enrolment get(Long id);

	List<Enrolment> getAll(String neighborhood);

	void delete(Long id);
}

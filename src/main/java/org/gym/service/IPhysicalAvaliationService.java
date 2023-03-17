package org.gym.service;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.form.PhysicalAvaliationForm;
import org.gym.entity.form.PhysicalAvaliationUpdateForm;
import org.gym.handler.PhysicalAvaliationNotFoundException;
import org.gym.handler.StudentNotFoundException;

public interface IPhysicalAvaliationService {
	PhysicalAvaliation create(PhysicalAvaliationForm form)
			throws StudentNotFoundException;

	PhysicalAvaliation get(Long id)
			throws PhysicalAvaliationNotFoundException;

	List<PhysicalAvaliation> getAll();

	PhysicalAvaliation update(
			Long id, PhysicalAvaliationUpdateForm form)
			    throws PhysicalAvaliationNotFoundException;

	void delete(Long id) throws PhysicalAvaliationNotFoundException;
}

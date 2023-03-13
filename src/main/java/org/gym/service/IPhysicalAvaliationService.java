package org.gym.service;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.form.PhysicalAvaliationForm;
import org.gym.entity.form.PhysicalAvaliationUpdateForm;

public interface IPhysicalAvaliationService {
	PhysicalAvaliation create(PhysicalAvaliationForm form);

	PhysicalAvaliation get(Long id);

	List<PhysicalAvaliation> getAll();

	PhysicalAvaliation update(Long id, PhysicalAvaliationUpdateForm form);

	void delete(Long id);
}

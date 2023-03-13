package org.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.gym.entity.PhysicalAvaliation;

@Repository
public interface PhysicalAvaliationsRepository
	extends JpaRepository<PhysicalAvaliation, Long> { }

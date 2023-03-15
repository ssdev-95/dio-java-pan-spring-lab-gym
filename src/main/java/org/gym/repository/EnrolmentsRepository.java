package org.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.gym.entity.Enrolment;

@Repository
public interface EnrolmentsRepository
	extends JpaRepository<Enrolment, Long> { }

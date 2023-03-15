package org.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.gym.entity.Student;

@Repository
public interface StudentsRepository
	extends JpaRepository<Student, Long> { }

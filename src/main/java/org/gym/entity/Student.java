package org.gym.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_students")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Student {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true)
	private Long cpf;
	private String neighborhood;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PhysicalAvaliation> avaliations = new ArrayList<>();
}

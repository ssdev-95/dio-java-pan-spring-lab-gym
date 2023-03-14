package org.gym.entity.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateForm {
	private String name;
	private String neighborhood;
	private LocalDate birthDate;
}

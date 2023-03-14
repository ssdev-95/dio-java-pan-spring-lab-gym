package org.gym.entity.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateForm {
	@NotNull(message = "Cannot leave empty fields: name.")
	@Size(min = 3, max =50, message = "'${validatedValue}' must be between {min} and {max} characteres.")
	private String name;
	@NotNull(message = "Cannot leave empty fields: neighborhood.")
	private String neighborhood;
	@NotNull(message = "Cannot leave empty fields: birthDate.")
	@Past(message = "Date '${validatedValue}' is invalid.")
	private LocalDate birthDate;
}

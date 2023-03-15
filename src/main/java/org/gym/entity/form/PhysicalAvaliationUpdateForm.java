package org.gym.entity.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalAvaliationUpdateForm {
	@NotNull(message = "Cannot leave empty fields: height")
	@Positive(message = "Height must be a positive value")
	private Double weight;
	@NotNull(message = "Cannot leave empty fields: weight")
	@Positive(message = "Height must be a positive value")
	private Double height;
}

package org.gym.entity.form;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalAvaliationForm {
  @Positive(message = "The given student's ID must be positive.")
  private Long studentId;
  @NotNull(message = "Cannot leave empty fields: weight.")
	@Positive(message = "${validatedValue}' precisa ser positivo.")
  private double weight;
  @NotNull(message = "Cannot leave empty fields: height.")
  @Positive(message = "${validatedValue}' must be positive.")
  @DecimalMin(value = "150", message = "'${validatedValue}' needs to reach at least {value}.")
  private double height;
}

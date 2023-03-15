package org.gym.entity.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrolmentForm {
  @NotNull(message = "Cannot send empty fields: studentId.")
  @Positive(message = "The student Id must be positive.")
  private Long studentId;
}

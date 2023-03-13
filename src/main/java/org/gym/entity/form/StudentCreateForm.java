package  org.gym.entity.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateForm {
	@NotEmpty(message = "Cannot send empty fields: name")
	@Size(min = 3, max =50, message = "'${validatedValue}' must be between {min} and {max} characteres.")
	private String name;

	@NotEmpty(message = "Cannot send empty fields: neighborhood")
	@Size(min = 3, max =50, message = "'${validatedValue}' must be between {min} and {max} characteres.")
	private String neighborhood;

	@NotEmpty(message = "Cannot send empty fields: cpf")
	private Long cpf;

	@NotNull(message = "Cannot send empty fields: birthDate")
	@Past(message = "Date '${validatedValue}' is invalid.")
	private LocalDate birthDate;
}

package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.employee.util.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {
    
    @Schema(
          description = "Representa el tipo de documento del empleado.",
          name = "type",
          implementation = String.class,
          pattern = Constants.REGEXP_DOCUMENT_TYPE,
          example = "DNI",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull
  @NotBlank
  @Pattern(regexp = Constants.REGEXP_DOCUMENT_TYPE)
  private String type;

  @Schema(
          description = "Representa el numero de documento del empleado.",
          name = "number",
          implementation = String.class,
          pattern = Constants.REGEXP_ONLY_NUMBER,
          example = "12345678",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull
  @NotBlank
  @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
  private String number;

}

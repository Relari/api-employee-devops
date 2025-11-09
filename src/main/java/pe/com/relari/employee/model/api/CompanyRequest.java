package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {

    @Schema(
            description = "Cargo del Empleado",
            name = "jobTitle",
            type = "String",
            example = "Developer",
            required = true)
    @NotBlank
    private String jobTitle;

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            type = "Double",
            example = "1000.00",
            required = true)
    @NotNull
    private Double salary;

}

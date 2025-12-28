package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse {

    @Schema(
            description = "Cargo del Empleado",
            name = "jobTitle",
            implementation = String.class,
            example = "Developer")
    private String jobTitle;

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            implementation = Double.class,
            example = "1000.00")
    private Double salary;

}

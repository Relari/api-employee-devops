
package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Class: EmployeeRequest.
 * @author Relari
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @Schema(
            description = "Nombre del Empleado",
            name = "firstName",
            implementation = String.class,
            example = "Renzo",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            implementation = String.class,
            example = "Lavado",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            implementation = String.class,
            example = "Lavado",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "gender",
            implementation = String.class,
            example = "M o F",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Pattern(regexp = "[M|F]")
    private String gender;

    @Valid
    @NotNull
    private CompanyRequest company;

    @Valid
    @NotNull
    private AddressRequest address;

}
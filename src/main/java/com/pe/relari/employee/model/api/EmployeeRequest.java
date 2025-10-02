
package com.pe.relari.employee.model.api;

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
            type = "String",
            example = "Renzo",
            required = true)
    @NotBlank
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            type = "String",
            example = "Lavado",
            required = true)
    @NotBlank
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            type = "String",
            example = "Lavado",
            required = true)
    @NotBlank
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "gender",
            type = "String",
            example = "M o F",
            required = true)
    @NotBlank
    @Pattern(regexp = "[M|F]")
    private String gender;

    @Schema(
            description = "Cargo del Empleado",
            name = "position",
            type = "String",
            example = "Developer",
            required = true)
    @NotBlank
    private String position;

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            type = "Double",
            example = "1000.00",
            required = true)
    @NotNull
    private Double salary;

    @Valid
    @NotNull
    private AddressRequest address;

}

package com.pe.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @Schema(
            description = "Id del Empleado",
            name = "firstName",
            type = "Integer",
            example = "1",
            required = true)
    @NotNull
    private Integer id;

    @Schema(
            description = "Nombre del Empleado",
            name = "name",
            type = "String",
            example = "Renzo",
            required = true)
    @NotBlank
    private String name;

    @Schema(
            description = "Apellido del Empleado",
            name = "lastName",
            type = "String",
            example = "Lavado",
            required = true)
    @NotBlank
    private String lastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "sex",
            type = "String",
            example = "M o F",
            required = true)
    @NotBlank
    @Pattern(regexp = "[M|F]")
    private String sex;

    @Valid
    @NotNull
    private AddressRequest address;

}
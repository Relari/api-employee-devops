package com.pe.relari.employee.model.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    @Schema(
            description = "Id del Empleado",
            name = "firstName",
            type = "Integer",
            example = "1",
            required = true)
    private Integer id;

    @Schema(
            description = "Nombre del Empleado",
            name = "name",
            type = "String",
            example = "Renzo",
            required = true)
    private String name;

    @Schema(
            description = "Apellido del Empleado",
            name = "lastName",
            type = "String",
            example = "Lavado",
            required = true)
    private String lastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "sex",
            type = "String",
            example = "M o F",
            required = true)
    private String sex;

}
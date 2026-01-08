package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Class: EmployeeDetailResponse.
 * @author Relari
 */

public record DefaultResponse<T> (
        @Schema(
                description = "Codigo HTTP.",
                name = "code",
                implementation = String.class,
                example = "OK")
        String code,
        @Schema(
                description = "Estatus HTTP.",
                name = "status",
                implementation = Integer.class,
                example = "200")
        Integer status,
        @Schema(
                description = "Data de respuesta.",
                name = "data",
                implementation = EmployeeResponse.class)
        T data
) {}

package pe.com.relari.employee.exception.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetail {

    @Schema(
            description = "Representa el nombre del componente.",
            name = "data",
            implementation = String.class,
            example = "parametro")
    private String data;

    @Schema(
            description = "Representa la descripcion del error programado.",
            name = "description",
            implementation = String.class,
            example = "El parametros es requerido y no puede ser nulo.")
    private String description;

}

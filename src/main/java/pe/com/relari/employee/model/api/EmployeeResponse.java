package pe.com.relari.employee.model.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class: EmployeeResponse.
 * @author Relari
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    @Schema(
            description = "Id del Empleado",
            name = "firstName",
            type = "Integer",
            example = "1")
    private Integer id;

    @Schema(
            description = "Nombre del Empleado",
            name = "name",
            type = "String",
            example = "Renzo")
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            type = "String",
            example = "Lavado")
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            type = "String",
            example = "Lavado")
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "gender",
            type = "String",
            example = "M o F")
    private String gender;

    private AddressResponse address;
    private CompanyResponse company;

    @Schema(
            description = "Estado del Empleado",
            name = "status",
            type = "Double",
            example = "true")
    private Boolean status;

}
package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: AddressResponse.
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          implementation = String.class,
          example = "email@mail.com")
  private String email;

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "phoneNumber",
          implementation = String.class,
          example = "999999999")
  private String phoneNumber;

}

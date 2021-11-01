package com.pe.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          type = "String",
          example = "email@mail.com",
          required = true)
  @NotBlank
  @Email
  private String email;

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          type = "String",
          example = "999999999",
          required = true)
  @NotBlank
  @Pattern(regexp = "[0-9]{9}")
  private String phoneNumber;

}
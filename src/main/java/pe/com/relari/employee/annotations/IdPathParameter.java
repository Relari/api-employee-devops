package pe.com.relari.employee.annotations;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameter(
        description = "Id del Empleado",
        name = "id",
        in = ParameterIn.PATH,
        example = "1",
        required = true
)
public @interface IdPathParameter {
}

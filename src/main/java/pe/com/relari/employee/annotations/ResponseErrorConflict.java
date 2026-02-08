package pe.com.relari.employee.annotations;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import pe.com.relari.employee.exception.model.ErrorResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
        responseCode = "409",
        content = @Content(
                schema = @Schema(implementation = ErrorResponse.class),
                mediaType = MediaType.APPLICATION_JSON_VALUE
        )
)
public @interface ResponseErrorConflict {
}

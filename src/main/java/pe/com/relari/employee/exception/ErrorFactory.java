package pe.com.relari.employee.exception;

import pe.com.relari.config.ApplicationProperties;
import pe.com.relari.employee.exception.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorFactory {

  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  private ApplicationProperties applicationProperties;

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ErrorResponse> apiException(
          ApiException apiException) {

    var errorDetail = applicationProperties.getErrors().getValue(apiException.getCatalog());

    return ResponseEntity.status(errorDetail.getStatus().getStatusCode())
            .body(new ErrorResponse(
                    errorDetail.getStatus(), errorDetail.mutate().component(applicationName).build()
            ));
  }

}

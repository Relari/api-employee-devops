package pe.com.relari.config;

import pe.com.relari.employee.exception.ErrorCategory;
import pe.com.relari.employee.exception.model.ErrorDetail;
import pe.com.relari.employee.util.GenericMap;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * <b>Class:</b> ErrorProperties.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Data
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application.backend")
public class ErrorProperties {

  private GenericMap<ErrorCategory, ErrorDetail> errors;

}

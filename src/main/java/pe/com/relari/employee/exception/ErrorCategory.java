package pe.com.relari.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCategory {

    EMPLOYEE_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR),
    EMPLOYEE_NOT_FOUND(HttpStatus.NOT_FOUND),
    EMPLOYEE_UPDATE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR),
    EMPLOYEE_INACTIVATED(HttpStatus.CONFLICT),
    EMPLOYEE_ACTIVATED(HttpStatus.CONFLICT);

    private final HttpStatus status;

}

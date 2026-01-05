package pe.com.relari.employee.model.api;

/**
 * Class: EmployeeDetailResponse.
 * @author Relari
 */

public record DefaultResponse<T> (
        String code,
        Integer status,
        T data
) {}

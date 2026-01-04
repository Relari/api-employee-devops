package pe.com.relari.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.api.EmployeeResponse;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.util.Constants;
import pe.com.relari.employee.util.DateUtils;

import java.time.LocalDateTime;

/**
 * Class: EmployeeMapper.
 *
 * @author Relari
 */

@Mapper(imports = { DateUtils.class, Constants.class, LocalDateTime.class })
public interface DomainToDtoMapper {

    DomainToDtoMapper INSTANCE = Mappers.getMapper(DomainToDtoMapper.class);

    @Mapping(target = "id", source = "idEmployee")
    @Mapping(target = "gender", expression = "java( employee.getGender().name() )")
    @Mapping(target = "dateOfBirth", expression = "java( DateUtils.format(employee.getDateOfBirth()) )")
    EmployeeResponse mapEmployeeResponse(Employee employee);

    @Mapping(target = "idEmployee", ignore = true)
    @Mapping(target = "dateOfBirth", expression = "java( DateUtils.parse(employeeRequest.getDateOfBirth()) )")
    @Mapping(target = "createdAt", expression = "java( LocalDateTime.now() )")
    @Mapping(target = "status", expression = "java( Constants.ACTIVE )")
    Employee mapEmployee(EmployeeRequest employeeRequest);

}
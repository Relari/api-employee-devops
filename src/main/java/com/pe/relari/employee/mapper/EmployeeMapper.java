package com.pe.relari.employee.mapper;

import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.model.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {


    public static Employee mapEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .lastName(employeeEntity.getLastName())
                .sex(employeeEntity.getSex())
                .build();
    }

    public static EmployeeEntity mapEmployeeEntity(Employee employee) {
        return EmployeeEntity.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .sex(employee.getSex())
                .build();
    }

}

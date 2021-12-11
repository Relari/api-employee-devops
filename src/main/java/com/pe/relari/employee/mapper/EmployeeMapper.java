package com.pe.relari.employee.mapper;

import com.pe.relari.employee.model.domain.Address;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.model.entity.EmployeeEntity;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

    private static final AtomicInteger id = new AtomicInteger(1);

    public static Employee mapEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .lastName(employeeEntity.getLastName())
                .sex(employeeEntity.getSex())
                .address(new Address(
                        employeeEntity.getEmail(),
                        employeeEntity.getPhoneNumber())
                )
                .build();
    }

    public static EmployeeEntity mapEmployeeEntity(Employee employee) {
        return EmployeeEntity.builder()
                .id(id.getAndIncrement())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .sex(employee.getSex())
                .email(employee.getAddress().getEmail())
                .phoneNumber(employee.getAddress().getPhoneNumber())
                .build();
    }

}

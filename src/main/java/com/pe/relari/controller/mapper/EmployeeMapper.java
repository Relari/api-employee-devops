package com.pe.relari.controller.mapper;

import com.pe.relari.employee.model.api.AddressResponse;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.model.api.EmployeeResponse;
import com.pe.relari.employee.model.domain.Address;
import com.pe.relari.employee.model.domain.Employee;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class: EmployeeMapper.
 * @author Relari
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

    private static final AtomicInteger id = new AtomicInteger(1);

    public static EmployeeResponse mapEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .sex(employee.getSex())
                .build();
    }

    public static AddressResponse mapAddressResponse(Address address) {
        return new AddressResponse(address.getEmail(), address.getPhoneNumber());
    }

    public static Employee mapEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .id(id.getAndIncrement())
                .name(employeeRequest.getName())
                .lastName(employeeRequest.getLastName())
                .sex(employeeRequest.getSex())
                .address(
                        new Address(
                                employeeRequest.getAddress().getEmail(),
                                employeeRequest.getAddress().getPhoneNumber()
                        )
                )
                .build();
    }

}
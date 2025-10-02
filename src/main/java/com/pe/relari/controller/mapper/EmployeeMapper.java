package com.pe.relari.controller.mapper;

import com.pe.relari.employee.model.api.AddressResponse;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.model.api.EmployeeResponse;
import com.pe.relari.employee.model.domain.Address;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.util.GenderEnum;
import com.pe.relari.employee.util.PositionEnum;

/**
 * Class: EmployeeMapper.
 * @author Relari
 */

public class EmployeeMapper {

    private EmployeeMapper() {}

    public static EmployeeResponse mapEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getIdEmployee())
                .firstName(employee.getFirstName())
                .fatherLastName(employee.getFatherLastName())
                .motherLastName(employee.getMotherLastName())
                .gender(employee.getGender().name())
                .position(employee.getPosition().name())
                .salary(employee.getSalary())
                .status(employee.getIsActive())
                .build();
    }

    public static AddressResponse mapAddressResponse(Address address) {
        return new AddressResponse(address.getEmail(), address.getPhoneNumber());
    }

    public static Employee mapEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .fatherLastName(employeeRequest.getFatherLastName())
                .motherLastName(employeeRequest.getMotherLastName())
                .gender(GenderEnum.valueOf(employeeRequest.getGender()))
                .position(PositionEnum.valueOf(employeeRequest.getPosition()))
                .salary(employeeRequest.getSalary())
                .address(
                        new Address(
                                employeeRequest.getAddress().getEmail(),
                                employeeRequest.getAddress().getPhoneNumber()
                        )
                )
                .isActive(Boolean.TRUE)
                .build();
    }

}
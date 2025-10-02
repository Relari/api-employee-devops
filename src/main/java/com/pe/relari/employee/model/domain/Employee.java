package com.pe.relari.employee.model.domain;

import com.pe.relari.employee.dao.repository.entity.EmployeeEntity;
import com.pe.relari.employee.util.GenderEnum;
import com.pe.relari.employee.util.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Class: Employee.
 * @author Relari
 */

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer idEmployee;
    private String fatherLastName;
    private String motherLastName;
    private String firstName;
    private PositionEnum position;
    private GenderEnum gender;
    private Double salary;
    private Address address;
    private Boolean isActive;

    public static Employee to(EmployeeEntity employeeEntity) {
        return builder()
                .idEmployee(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .gender(employeeEntity.getGender())
                .position(employeeEntity.getPosition())
                .salary(employeeEntity.getSalary())
                .isActive(employeeEntity.getIsActive())
                .build();
    }

}
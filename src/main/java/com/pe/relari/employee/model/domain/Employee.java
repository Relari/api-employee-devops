package com.pe.relari.employee.model.domain;

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

    private Integer id;
    private String name;
    private String lastName;
    private String sex;
    private String position;
    private Double salary;
    private Address address;
    private Boolean status;

}
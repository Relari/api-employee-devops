package com.pe.relari.employee.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    private Integer id;
    private String name;
    private String lastName;
    private String sex;

}

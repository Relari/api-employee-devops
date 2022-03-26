package com.pe.relari.employee.util;

import com.pe.relari.employee.model.domain.Address;
import com.pe.relari.employee.model.domain.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

    public static Employee buildEmployee() {
        return Employee.builder()
                .id(1)
                .name("Name")
                .lastName("Last Name")
                .sex("Sex")
                .address(new Address("email", "phone number"))
                .build();
    }

}

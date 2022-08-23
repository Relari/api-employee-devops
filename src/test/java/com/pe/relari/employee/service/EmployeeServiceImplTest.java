package com.pe.relari.employee.service;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeServiceImplTest {

    private static EmployeeService service = new EmployeeServiceImpl();

    @BeforeEach
    void init() {
        service.save(buildEmployee());
    }

    @Test
    void findAll() {

        var employee = buildEmployee();

        var employees = service.findAll();

        assertEquals(employee.getId(), employees.get(0).getId());
        assertEquals(employee.getName(), employees.get(0).getName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employee.getSex(), employees.get(0).getSex());
        assertEquals(employee.getAddress().getEmail(), employees.get(0).getAddress().getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), employees.get(0).getAddress().getPhoneNumber());

    }

    @Test
    void deleteAll() {

        var employee = buildEmployee();

        service.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        service.deleteById(id);

        assertNotNull(id);
    }

    @Test
    void findById() {

        var employee = service.findById(1);
        assertNotNull(employee);

    }

    @Test
    void findByIdError() {

        assertThrows(RuntimeException.class, () -> service.findById(2));

    }
}
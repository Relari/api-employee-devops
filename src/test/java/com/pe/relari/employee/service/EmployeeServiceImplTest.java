package com.pe.relari.employee.service;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pe.relari.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        var employee = buildEmployee();

        Mockito.when(employeeDao.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employees = employeeService.findAll();

        assertEquals(employee.getIdEmployee(), employees.get(0).getIdEmployee());
        assertEquals(employee.getFirstName(), employees.get(0).getFirstName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employee.getSex(), employees.get(0).getSex());
        assertEquals(employee.getAddress().getEmail(), employees.get(0).getAddress().getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), employees.get(0).getAddress().getPhoneNumber());

    }

    @Test
    void deleteAll() {

        var employee = buildEmployee();

        employeeDao.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        employeeDao.deleteById(id);

        assertNotNull(id);
    }

    @Test
    void findById() {

        var employee = buildEmployee();

        Mockito.when(employeeDao.findById(Mockito.anyInt()))
                .thenReturn(employee);

        var employeeDomain = employeeService.findById(1);
        assertEquals(employee.getIdEmployee(), employeeDomain.getIdEmployee());
        assertEquals(employee.getFirstName(), employeeDomain.getFirstName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employee.getSex(), employeeDomain.getSex());
        assertEquals(employee.getAddress().getEmail(), employeeDomain.getAddress().getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), employeeDomain.getAddress().getPhoneNumber());


    }

}
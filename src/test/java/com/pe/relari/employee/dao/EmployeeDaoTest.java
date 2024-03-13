package com.pe.relari.employee.dao;

import static com.pe.relari.employee.util.TestUtil.buildEmployeeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pe.relari.employee.dao.impl.EmployeeDaoImpl;
import com.pe.relari.employee.dao.repository.EmployeeRepository;
import com.pe.relari.employee.exception.ApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

class EmployeeDaoTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeDaoImpl employeeDao;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        var employeeEntity = buildEmployeeEntity();

        Mockito.when(employeeRepository.findAll())
                .thenReturn(Collections.singletonList(employeeEntity));

        var employees = employeeDao.findAll();

//        assertEquals(employeeEntity.getId(), employees.get(0).getIdEmployee());
        assertEquals(employeeEntity.getFirstName(), employees.get(0).getFirstName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employeeEntity.getSex(), employees.get(0).getSex());
//        assertEquals(employeeEntity.getAddress().getEmail(), employees.get(0).getAddress().getEmail());
//        assertEquals(employeeEntity.getAddress().getPhoneNumber(), employees.get(0).getAddress().getPhoneNumber());

    }

    @Test
    void deleteAll() {

        var employee = buildEmployeeEntity();

        employeeRepository.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        employeeRepository.deleteById(id);

        assertNotNull(id);
    }

    @Test
    void findById() {

        var employeeEntity = buildEmployeeEntity();

        Mockito.when(employeeRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(employeeEntity));

        var employeeDomain = employeeDao.findById(1);
//        assertEquals(employeeEntity.getIdEmployee(), employeeDomain.getIdEmployee());
        assertEquals(employeeEntity.getFirstName(), employeeDomain.getFirstName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employeeEntity.getSex(), employeeDomain.getSex());
//        assertEquals(employeeEntity.getAddress().getEmail(), employeeDomain.getAddress().getEmail());
//        assertEquals(employeeEntity.getAddress().getPhoneNumber(), employeeDomain.getAddress().getPhoneNumber());


    }

    @Test
    void findByIdError() {

        Mockito.when(employeeRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(ApiException.class, () -> employeeDao.findById(2));

    }
}
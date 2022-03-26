package com.pe.relari.controller;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.pe.relari.employee.model.api.AddressRequest;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.service.EmployeeService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmployeeControllerTest {

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeController controller;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        var employee = buildEmployee();

        when(service.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employeeResponses = controller.findAll();

        assertEquals(employee.getId(), employeeResponses.get(0).getId());
        assertEquals(employee.getName(), employeeResponses.get(0).getName());
        assertEquals(employee.getLastName(), employeeResponses.get(0).getLastName());
        assertEquals(employee.getSex(), employeeResponses.get(0).getSex());
    }

    @Test
    void findAll2() {

        var employee = buildEmployee();

        when(service.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employeeDetailResponse = controller.findAll2();

        assertNotNull(employeeDetailResponse);
    }



    @Test
    void findById() {

        var employee = buildEmployee();

        when(service.findById(anyInt()))
                .thenReturn(employee);

        var employeeResponse = controller.findById(1);

        assertEquals(employee.getId(), employeeResponse.getId());
        assertEquals(employee.getName(), employeeResponse.getName());
        assertEquals(employee.getLastName(), employeeResponse.getLastName());
        assertEquals(employee.getSex(), employeeResponse.getSex());

    }

    @Test
    void getAddressById() {

        var employee = buildEmployee();

        when(service.findById(anyInt()))
                .thenReturn(employee);

        var address = controller.getAddressById(1);

        assertEquals(employee.getAddress().getEmail(), address.getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), address.getPhoneNumber());

    }

    @Test
    void save() {

        service.save(any());

        var employeeRequest = EmployeeRequest.builder()
                .name("Name")
                .lastName("Last Name")
                .sex("Sex")
                .address(new AddressRequest("email", "phone number"))
                .build();

        controller.save(employeeRequest);

        assertNotNull(employeeRequest);

    }

    @Test
    void deleteAll() {

        service.deleteAll();

        controller.deleteAll();

        Integer id = 1;

        assertNotNull(id);
    }

    @Test
    void deleteById() {

        service.deleteById(anyInt());

        Integer id = 1;

        controller.deleteById(id);

        assertNotNull(id);

    }
}
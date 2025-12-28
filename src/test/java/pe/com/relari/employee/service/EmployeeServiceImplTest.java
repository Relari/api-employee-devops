package pe.com.relari.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.service.impl.EmployeeServiceImpl;
import pe.com.relari.employee.util.DataMocks;
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

        var employee = DataMocks.buildEmployee();

        Mockito.when(employeeDao.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employees = employeeService.findAll();

        assertEquals(employee.getFirstName(), employees.get(0).getFirstName());
        assertEquals(employee.getFatherLastName(), employees.get(0).getFatherLastName());
        assertEquals(employee.getMotherLastName(), employees.get(0).getMotherLastName());
        assertEquals(employee.getGender(), employees.get(0).getGender());

    }

    @Test
    void deleteAll() {

        var employee = DataMocks.buildEmployee();

        employeeDao.deleteAll();

        employeeService.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        employeeDao.deleteById(Mockito.anyInt());

        employeeService.deleteById(id);

        assertNotNull(id);
    }

    @Test
    void findById() {

        var employee = DataMocks.buildEmployee();

        Mockito.when(employeeDao.findById(Mockito.anyInt()))
                .thenReturn(employee);

        var response = employeeService.findById(1);

        assertEquals(employee.getFirstName(), response.getFirstName());
        assertEquals(employee.getFatherLastName(), response.getFatherLastName());
        assertEquals(employee.getMotherLastName(), response.getMotherLastName());
        assertEquals(employee.getGender(), response.getGender());

    }

    @Test
    void save() {
        employeeDao.save(Mockito.any());

        var employee = DataMocks.buildEmployee();
        employeeService.save(employee);

        assertNotNull(employee);
    }


}
package com.pe.relari.employee.service;

import com.pe.relari.employee.exception.ApiException;
import com.pe.relari.employee.exception.ErrorCategory;
import com.pe.relari.employee.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Class: EmployeeServiceImpl.
 * @author Relari
 */

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        log.debug("get all employees");
        return employees;
    }

    @Override
    public void save(Employee employee) {
        log.debug("save new employee");
        employees.add(employee);
    }

    @Override
    public void deleteAll() {
        log.debug("delete all employee");
        employees = new ArrayList<>();
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("delete employee by id = {}", id);
        employees.removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public Employee findById(Integer id) {
        log.debug("search employee by id = {}", id);
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> ApiException.of(ErrorCategory.EMPLOYEE_NOT_FOUND));
    }
}

package com.pe.relari.employee.service;

import com.pe.relari.employee.model.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteAll();

    void deleteById(Integer id);

    Employee findById(Integer id);
}

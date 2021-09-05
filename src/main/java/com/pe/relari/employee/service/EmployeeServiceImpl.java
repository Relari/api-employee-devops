package com.pe.relari.employee.service;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.model.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) {

        var employeeModel = employeeDao.findAll()
                .stream()
                .filter(employeeDomain -> employeeDomain.getId().equals(employee.getId()))
                .findFirst()
                .orElseGet(() -> saveEmployee(employee));

        log.trace(employeeModel.toString());
    }

    private Employee saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {

        var employeeId = employeeDao.findById(id).getId();
        employeeDao.deleteById(employeeId);

    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }
}

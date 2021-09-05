package com.pe.relari.employee.dao;

import com.pe.relari.employee.mapper.EmployeeMapper;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.dao.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {

        log.debug("Listing all employees.");

        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::mapEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Employee employee) {

        var employeeEntity = EmployeeMapper.mapEmployeeEntity(employee);

        log.debug("Saving the new employee.");

        if (employeeRepository.save(employeeEntity)) {
            log.info("It was saved correctly to the employee.");
        } else {
            log.error("An error occurred while saving the employee.");
        }

    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {

        log.debug("Eliminating the employee.");

        if (employeeRepository.deleteById(id)) {
            log.info("The employee was successfully eliminated.");
        } else {
            log.error("An error occurred while removing the employee.");
        }
    }


    @Override
    public Employee findById(Integer id) {

        log.debug("Looking for the employee.");

        return employeeRepository.findById(id)
                .map(EmployeeMapper::mapEmployee)
                .orElseThrow(() -> new RuntimeException("The employee was not found."));
    }


}

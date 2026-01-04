package pe.com.relari.employee.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.dao.mapper.DomainToEntityMapper;
import pe.com.relari.employee.dao.repository.EmployeeRepository;
import pe.com.relari.employee.exception.ApiException;
import pe.com.relari.employee.exception.ErrorCategory;
import pe.com.relari.employee.model.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Class: EmployeeDaoImpl.
 * @author Relari
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(DomainToEntityMapper.INSTANCE::mapEmployee)
                .toList();
    }

    @Override
    public void save(Employee employee) {

        Optional.of(employee)
                .map(DomainToEntityMapper.INSTANCE::mapEmployeeEntity)
                .map(employeeRepository::save)
                .ifPresent(savedEntity -> log.debug("Employee saved with ID: {}", savedEntity.getId()));

    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .map(DomainToEntityMapper.INSTANCE::mapEmployee)
                .orElseThrow(() -> ApiException.of(ErrorCategory.EMPLOYEE_NOT_FOUND));
    }
}

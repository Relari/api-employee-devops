package pe.com.relari.employee.dao.impl;

import lombok.RequiredArgsConstructor;
import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.dao.repository.EmployeeRepository;
import pe.com.relari.employee.exception.ApiException;
import pe.com.relari.employee.exception.ErrorCategory;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class: EmployeeDaoImpl.
 * @author Relari
 */

@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(Employee::to)
                .toList();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(
                EmployeeEntity.to(employee)
        );
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
                .map(Employee::to)
                .orElseThrow(() -> ApiException.of(ErrorCategory.EMPLOYEE_NOT_FOUND));
    }
}

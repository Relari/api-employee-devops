package pe.com.relari.employee.service;

import pe.com.relari.employee.model.domain.Employee;

import java.util.List;

/**
 * Interface: EmployeeService.
 * @author Relari
 */
public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteAll();

    void deleteById(Integer id);

    Employee findById(Integer id);
}

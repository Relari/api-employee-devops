package pe.com.relari.employee.service.impl;

import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class: EmployeeServiceImpl.
 * @author Relari
 */

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }
}

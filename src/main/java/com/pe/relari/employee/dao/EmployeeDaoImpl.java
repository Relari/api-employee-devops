package com.pe.relari.employee.dao;

import com.pe.relari.employee.mapper.EmployeeMapper;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.dao.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::mapEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Employee employee) {

        var employeeEntity = EmployeeMapper.mapEmployeeEntity(employee);
        employeeRepository.save(employeeEntity);

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
                .map(EmployeeMapper::mapEmployee)
                .orElseThrow(() -> new RuntimeException("No se encontro"));
    }


}

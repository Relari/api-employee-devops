package com.pe.relari.employee.dao.repository;

import com.pe.relari.employee.model.entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<EmployeeEntity> employeeEntities = new ArrayList<>();

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeEntities;
    }

    @Override
    public boolean save(EmployeeEntity employeeEntity) {
        return employeeEntities.add(employeeEntity);
    }

    @Override
    public void deleteAll() {
        employeeEntities = new ArrayList<>();
    }

    @Override
    public boolean deleteById(Integer id) {
        return employeeEntities.removeIf(
                employeeEntity -> employeeEntity.getId().equals(id)
        );
    }

    @Override
    public Optional<EmployeeEntity> findById(Integer id) {
        return employeeEntities.stream()
                .filter(employeeEntity -> employeeEntity.getId().equals(id))
                .findFirst();
    }

}
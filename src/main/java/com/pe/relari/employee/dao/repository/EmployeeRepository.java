package com.pe.relari.employee.dao.repository;

import com.pe.relari.employee.model.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<EmployeeEntity> findAll();

    boolean save(EmployeeEntity employeeEntity);

    void deleteAll();

    boolean deleteById(Integer id);

    Optional<EmployeeEntity> findById(Integer id);

}

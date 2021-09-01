package com.pe.relari.controller;

import com.pe.relari.controller.mapper.EmployeeMapper;
import com.pe.relari.employee.service.EmployeeService;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.model.api.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll()
                .stream()
                .map(EmployeeMapper::mapEmployeeResponse)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public EmployeeResponse findById(@PathVariable(name = "id") Integer id) {
        return EmployeeMapper.mapEmployeeResponse(
                employeeService.findById(id)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody EmployeeRequest employeeRequest) {
        var employeeEntity = EmployeeMapper.mapEmployee(employeeRequest);
        employeeService.save(employeeEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll() {
        employeeService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable(name = "id") Integer id) {
        employeeService.deleteById(id);
    }
}

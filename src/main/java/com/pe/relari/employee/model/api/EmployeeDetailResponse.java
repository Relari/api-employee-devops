package com.pe.relari.employee.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class EmployeeDetailResponse {

    private List<EmployeeResponse> employees;

}

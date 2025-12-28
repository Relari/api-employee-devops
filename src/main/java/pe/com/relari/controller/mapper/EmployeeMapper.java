package pe.com.relari.controller.mapper;

import pe.com.relari.employee.model.api.AddressResponse;
import pe.com.relari.employee.model.api.CompanyResponse;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.api.EmployeeResponse;
import pe.com.relari.employee.model.domain.Address;
import pe.com.relari.employee.model.domain.Company;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.model.domain.Gender;
import pe.com.relari.employee.model.domain.JobTitle;

/**
 * Class: EmployeeMapper.
 * @author Relari
 */

public class EmployeeMapper {

    private EmployeeMapper() {}

    public static EmployeeResponse mapEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getIdEmployee())
                .firstName(employee.getFirstName())
                .fatherLastName(employee.getFatherLastName())
                .motherLastName(employee.getMotherLastName())
                .gender(employee.getGender().name())
                .address(mapAddressResponse(employee.getAddress()))
                .company(new CompanyResponse(
                        employee.getCompany().getJobTitle().name(),
                        employee.getCompany().getSalary()
                ))
                .status(employee.getIsActive())
                .build();
    }

    public static AddressResponse mapAddressResponse(Address address) {
        return new AddressResponse(address.getEmail(), address.getPhoneNumber());
    }

    public static Employee mapEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .fatherLastName(employeeRequest.getFatherLastName())
                .motherLastName(employeeRequest.getMotherLastName())
                .gender(Gender.valueOf(employeeRequest.getGender()))
                .company(Company.of(
                        JobTitle.valueOf(employeeRequest.getCompany().getJobTitle()),
                        employeeRequest.getCompany().getSalary()
                ))
                .address(Address.of(
                        employeeRequest.getAddress().getEmail(),
                        employeeRequest.getAddress().getPhoneNumber()
                ))
                .isActive(Boolean.TRUE)
                .build();
    }

}
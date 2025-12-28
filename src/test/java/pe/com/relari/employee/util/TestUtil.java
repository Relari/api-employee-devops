package pe.com.relari.employee.util;

import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.employee.model.api.AddressRequest;
import pe.com.relari.employee.model.api.CompanyRequest;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.domain.Address;
import pe.com.relari.employee.model.domain.Company;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.model.domain.Gender;
import pe.com.relari.employee.model.domain.JobTitle;

public class TestUtil {

    private TestUtil() {}

    public static Employee buildEmployee() {
        return Employee.builder()
                .idEmployee(1)
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender(Gender.M)
                .company(Company.of(JobTitle.DEVELOPER, 2500.00))
                .address(Address.of("email@mail.com", "999000999"))
                .isActive(Boolean.TRUE)
                .build();
    }

    public static EmployeeRequest buildEmployeeRequest() {
        return EmployeeRequest.builder()
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender("M")
                .company(new CompanyRequest("DEVELOPER", 2500.00))
                .address(new AddressRequest("email@mail.com", "999000999"))
                .build();
    }

    public static EmployeeEntity buildEmployeeEntity() {
        return EmployeeEntity.builder()
                .id(1)
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender(Gender.M)
                .jobTitle(JobTitle.DEVELOPER)
                .salary(2500.00)
                .email("email@mail.com")
                .phoneNumber("999000999")
                .isActive(Boolean.TRUE)
                .build();
    }
}

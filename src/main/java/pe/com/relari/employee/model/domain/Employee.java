package pe.com.relari.employee.model.domain;

import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.employee.util.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Class: Employee.
 * @author Relari
 */

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer idEmployee;
    private String fatherLastName;
    private String motherLastName;
    private String firstName;
    private GenderEnum gender;
    private Address address;
    private Company company;
    private Boolean isActive;

    public static Employee to(EmployeeEntity employeeEntity) {
        return builder()
                .idEmployee(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .gender(employeeEntity.getGender())
                .address(Address.of(employeeEntity.getEmail(), employeeEntity.getPhoneNumber()))
                .company(Company.of(employeeEntity.getPosition(), employeeEntity.getSalary()))
                .isActive(employeeEntity.getIsActive())
                .build();
    }

}
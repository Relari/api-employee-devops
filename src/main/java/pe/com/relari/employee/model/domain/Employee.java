package pe.com.relari.employee.model.domain;

import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.employee.util.GenderEnum;
import pe.com.relari.employee.util.PositionEnum;
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
    private PositionEnum position;
    private GenderEnum gender;
    private Double salary;
    private Address address;
    private Boolean isActive;

    public static Employee to(EmployeeEntity employeeEntity) {
        return builder()
                .idEmployee(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .gender(employeeEntity.getGender())
                .position(employeeEntity.getPosition())
                .salary(employeeEntity.getSalary())
                .isActive(employeeEntity.getIsActive())
                .build();
    }

}
package pe.com.relari.employee.dao.repository.entity;

import jakarta.persistence.*;

import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.model.domain.Gender;
import pe.com.relari.employee.model.domain.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <b>Class:</b> EmployeeEntity.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fatherLastName", length = 50, nullable = false)
    private String fatherLastName;

    @Column(name = "motherLastName", length = 50, nullable = false)
    private String motherLastName;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "jobTitle", length = 50, nullable = false)
    private JobTitle jobTitle;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phoneNumber", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    public static EmployeeEntity to(Employee employee) {
        return builder()
                .firstName(employee.getFirstName())
                .fatherLastName(employee.getFatherLastName())
                .motherLastName(employee.getMotherLastName())
                .gender(employee.getGender())
                .jobTitle(employee.getCompany().getJobTitle())
                .salary(employee.getCompany().getSalary())
                .email(employee.getAddress().getEmail())
                .phoneNumber(employee.getAddress().getPhoneNumber())
                .isActive(Boolean.TRUE)
                .build();
    }
}

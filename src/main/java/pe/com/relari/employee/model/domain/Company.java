package pe.com.relari.employee.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.employee.util.PositionEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Company {

    private PositionEnum jobTitle;
    private Double salary;

}

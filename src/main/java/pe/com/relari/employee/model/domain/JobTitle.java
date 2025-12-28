package pe.com.relari.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobTitle {

    DEVELOPER("developer"),
    MANAGER("manager"),
    ARCHITECT("architect"),
    SCRUM_MASTER("scrum-master"),
    TEAM_LEAD("team-lead");

    private final String value;

}

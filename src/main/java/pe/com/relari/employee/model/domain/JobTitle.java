package pe.com.relari.employee.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JobTitle {

    DEVELOPER("developer"),
    MANAGER("manager"),
    ARCHITECT("architect"),
    SCRUM_MASTER("scrum-master"),
    TEAM_LEAD("team-lead");

    private final String value;

}

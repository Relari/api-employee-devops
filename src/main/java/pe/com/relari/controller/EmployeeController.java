package pe.com.relari.controller;

import lombok.RequiredArgsConstructor;
import pe.com.relari.controller.mapper.DomainToDtoMapper;
import pe.com.relari.employee.model.api.AddressResponse;
import pe.com.relari.employee.model.api.DefaultResponse;
import pe.com.relari.employee.service.EmployeeService;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.api.EmployeeResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import pe.com.relari.employee.util.Constants;

import java.util.List;

/**
 * Class: EmployeeController.
 * @author Relari
 */

@Tag(name = "Employee", description = "Employee Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Employee API",
                version = "${application.info.version}",
                description = "${application.info.description}")
)
@RestController
@RequestMapping(path = "${application.api.path}")
@RequiredArgsConstructor
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    @GetMapping
    @Override
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll()
                .stream()
                .map(DomainToDtoMapper.INSTANCE::mapEmployeeResponse)
                .toList();
    }

    @GetMapping(path = "/all")
    @Override
    public DefaultResponse<List<EmployeeResponse>> findAll2() {
        return DomainToDtoMapper.INSTANCE.mapResponse(employeeService.findAll());
    }

    @GetMapping(path = "/{id}")
    @Override
    public EmployeeResponse findById(
            @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
            @PathVariable(name = "id") String id) {
        return DomainToDtoMapper.INSTANCE.mapEmployeeResponse(
                employeeService.findById(Integer.valueOf(id))
        );
    }

    @GetMapping(path = "/{id}/address")
    @Override
    public AddressResponse getAddressById(
            @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
            @PathVariable(name = "id") String id) {
        var address = employeeService.findById(Integer.valueOf(id)).getAddress();
        return new AddressResponse(address.getEmail(), address.getPhoneNumber());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Override
    public void save(@RequestBody @Valid EmployeeRequest employeeRequest) {
        var employeeEntity = DomainToDtoMapper.INSTANCE.mapEmployee(employeeRequest);
        employeeService.save(employeeEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @Override
    public void deleteAll() {
        employeeService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteById(
            @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
            @PathVariable(name = "id") String id) {
        employeeService.deleteById(Integer.valueOf(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{id}/inactive")
    @Override
    public void inactiveById(
            @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
            @PathVariable(name = "id") String id) {
        employeeService.inactivateById(Integer.valueOf(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{id}/active")
    @Override
    public void activeById(
            @Pattern(regexp = Constants.REGEXP_ONLY_NUMBER)
            @PathVariable(name = "id") String id) {
        employeeService.activateById(Integer.valueOf(id));
    }

}

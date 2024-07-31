package com.billcom.drools.controller;


import com.billcom.drools.model.Employees;
import com.billcom.drools.repository.EmpRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@ComponentScan
public class SwagController {
    @Autowired
    private EmpRepository repository;

    public SwagController(EmpRepository repository) {
        this.repository = repository;
    }

    @Tag(name = "get", description = "GET methods of Employee APIs")
    @GetMapping("/employees")
    public List<Employees> findAllEmployees() {
        return repository.findAll();
    }

    @Tag(name = "get", description = "Retrieve one employee")
    @GetMapping("/employees/{employeeId}")
    public Employees getEmployee(@Parameter(
            description = "ID of employee to be retrieved",
            required = true)
                                @PathVariable String employeeId) {
        Employees employee = repository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee id not found - " + employeeId));
        return employee;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees employee) {
        Employees newEmployee = repository.save(employee);
        return newEmployee;
    }

    @Operation(summary = "Update an employee",
            description = "Update an existing employee. The response is updated Employee object with id, first name, and last name.")
    @PutMapping("/employees")
    public Employees updateEmployee(@RequestBody Employees employee) {
        Employees theEmployee = repository.save(employee);
        return theEmployee;
    }


    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Employees.class))}),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content)})
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        Employees employee = repository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee id not found - " + employeeId));
        repository.delete(employee);
        return "Deleted employee with id: " + employeeId;
    }

}
package com.crud.crudoperation.controller;

import com.crud.crudoperation.entity.Employee;
import com.crud.crudoperation.repository.EmployeeRepository;
import com.crud.crudoperation.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.crud.crudoperation.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceInterface.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeServiceInterface.getAllEmployee(), HttpStatus.FOUND);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam("employeeId") Long id) {
        Employee employee = employeeServiceInterface.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @Validated @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeServiceInterface.getEmployeeById(id);
        employeeToUpdate.setName(employee.getName());
        employeeServiceInterface.addEmployee(employeeToUpdate);
        return ResponseEntity.ok(employeeToUpdate);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        Employee employeeToDelete = employeeServiceInterface.deleteEmployee(id);
        return new ResponseEntity<>(employeeToDelete, HttpStatus.ACCEPTED);
    }

}

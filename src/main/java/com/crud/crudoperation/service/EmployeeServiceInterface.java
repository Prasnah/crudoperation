package com.crud.crudoperation.service;

import com.crud.crudoperation.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    public Employee addEmployee(Employee employee);

    public Employee getEmployeeById(long id);

    public List<Employee> getAllEmployee();

    public Employee deleteEmployee(Long id);
}

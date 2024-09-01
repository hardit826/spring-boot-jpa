package com.hardit_code.spring_boot_jpa.service;

import com.hardit_code.spring_boot_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

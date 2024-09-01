package com.hardit_code.spring_boot_jpa.dao;

import com.hardit_code.spring_boot_jpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

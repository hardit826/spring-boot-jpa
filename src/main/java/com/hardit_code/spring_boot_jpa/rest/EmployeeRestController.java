package com.hardit_code.spring_boot_jpa.rest;


import com.hardit_code.spring_boot_jpa.dao.EmployeeDAO;
import com.hardit_code.spring_boot_jpa.entity.Employee;
import com.hardit_code.spring_boot_jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //inject DAO
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose employee endpoints and return all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // GET / employees / {employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        return theEmployee;
    }

    // POST - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // PUT - update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // Delete - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}

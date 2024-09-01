package com.hardit_code.spring_boot_jpa.service;

import com.hardit_code.spring_boot_jpa.dao.EmployeeDAO;
import com.hardit_code.spring_boot_jpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    //Constructor Injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }


}

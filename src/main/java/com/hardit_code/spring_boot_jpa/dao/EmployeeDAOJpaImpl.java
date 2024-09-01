package com.hardit_code.spring_boot_jpa.dao;

import com.hardit_code.spring_boot_jpa.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public  EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query
        List<Employee> employees= theQuery.getResultList();

        //return all the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //get employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(theEmployee);
    }
}

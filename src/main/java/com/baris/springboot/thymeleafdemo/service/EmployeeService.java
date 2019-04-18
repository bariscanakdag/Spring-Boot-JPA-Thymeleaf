package com.baris.springboot.thymeleafdemo.service;

import com.baris.springboot.thymeleafdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();

    public Optional<Employee> findById(int theId);

    public void Save(Employee theEmployee);

    public void deleteById(int theId);

    public List<Employee> findAllByOrderByLastNameAsc();
}

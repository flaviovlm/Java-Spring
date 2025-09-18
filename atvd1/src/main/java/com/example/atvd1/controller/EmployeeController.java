package com.example.atvd1.controller;

import com.example.atvd1.model.Employee;
import com.example.atvd1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Savepoint;
import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List <Employee> listall(){

        return employeeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Employee> save (@RequestBody Employee employee){

        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
}

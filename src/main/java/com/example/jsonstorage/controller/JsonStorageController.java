package com.example.jsonstorage.controller;

import javax.validation.Valid;

import com.example.jsonstorage.entity.Employee;
import com.example.jsonstorage.service.JsonStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/json/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonStorageController {

    private JsonStorageService jsonStorageService;

    @Autowired
    public JsonStorageController(JsonStorageService jsonStorageService) {
        this.jsonStorageService = jsonStorageService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {

        return jsonStorageService.create(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId)
            throws ResourceNotFoundException {
        Employee employee = jsonStorageService.getById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return jsonStorageService.findAll();
    }
}

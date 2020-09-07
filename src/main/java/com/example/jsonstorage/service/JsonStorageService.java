package com.example.jsonstorage.service;


import com.example.jsonstorage.entity.Employee;
import com.example.jsonstorage.repository.JsonStorageRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsonStorageService {

    private JsonStorageRepository jsonStorageRepository;

    @Autowired
    public JsonStorageService(JsonStorageRepository jsonStorageRepository) {
        this.jsonStorageRepository = jsonStorageRepository;
    }

    public Employee create(Employee employee) {
        return jsonStorageRepository.save(employee);

    }

    public Employee getById(String id) {
        ObjectId objId = new ObjectId(id);
        Employee employee = jsonStorageRepository.findById(objId).orElseThrow(() -> new NullPointerException("Employee not found for this id :: " + id));
        return employee;
    }

    public List<Employee> findAll() {
        List<Employee> employees = jsonStorageRepository.findAll();
        return employees;
    }

}
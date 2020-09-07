package com.example.jsonstorage.repository;
import com.example.jsonstorage.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "employee", collectionResourceRel = "employee")
public interface JsonStorageRepository extends MongoRepository<Employee, ObjectId> {


    @Query("{firstName:'?0'}")
    List<Employee> findByFirstName(String firstName);
}

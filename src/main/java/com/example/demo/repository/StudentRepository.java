package com.example.demo.repository;

import com.example.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findStudentByFirstName(String firstName);
}

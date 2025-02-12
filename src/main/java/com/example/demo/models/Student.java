package com.example.demo.models;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime createdAt;

    public Student(String firstName, String lastName, Gender gender, Address address, List<String> favouriteSubjects, BigDecimal totalSpentInBooks, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.createdAt = createdAt;
    }
}

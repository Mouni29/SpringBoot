package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
         return studentService.getAllStudent();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return  studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") String id,@RequestBody Student updatedStudent) {
        return studentService.updateStudentDetails(id, updatedStudent);

    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudentById(studentId);
    }
}

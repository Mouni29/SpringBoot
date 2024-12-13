package com.example.demo.Service;


import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
   return studentRepository.findAll();
}

    public Student saveStudent(Student student) {
    return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }

    public Student updateStudentDetails(String id,Student updatedStudent) {
        Optional<Student> findById = getStudentById(id);
        if (findById.isEmpty()) {
            System.out.println("Student not found");
            return null;
        }

        Student existingStudent = findById.get();

        if(updatedStudent.getFirstName()!=null){
            existingStudent.setFirstName((updatedStudent.getFirstName()));
        }

        if(updatedStudent.getAddress()!=null){
            existingStudent.setAddress(updatedStudent.getAddress());
        }

        if(updatedStudent.getFavouriteSubjects()!=null){
            existingStudent.setFavouriteSubjects(updatedStudent.getFavouriteSubjects());
        }
        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(String studentId) {
        Optional<Student> student = getStudentById(studentId);
        if (student.isEmpty()) {
            System.out.println("Student not found");
            return;
        }
        studentRepository.deleteById(studentId);
    }
}

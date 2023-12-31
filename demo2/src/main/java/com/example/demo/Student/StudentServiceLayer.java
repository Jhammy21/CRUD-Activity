package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceLayer {
    private final StudentRepository studentRepository;

    @Autowired

    public StudentServiceLayer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();


    }

    public void addNewStudent(Student student) {
       Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");

        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
       boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String firstname,
                              String lastname,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id"+ studentId + "does not exist"));

                if (firstname != null &&
                firstname.length() > 0 &&
                !Objects.equals(student.getFirstname(),firstname)){
                    student.setFirstname(firstname);
                }
                if (lastname != null &&
                lastname.length() > 0 &&
                !Objects.equals(student.getLastname(),lastname)){
            student.setLastname(lastname);
        }
                if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),email)){
                    Optional<Student> studentOptional = studentRepository
                            .findStudentByEmail(email);
                    if (studentOptional.isPresent()){
                        throw new IllegalStateException("email is already taken");
                    }
                    student.setEmail(email);
                }
    }

}

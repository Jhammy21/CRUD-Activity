package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path ="api/v1/students")
public class StudentAPILayer {
    private final StudentServiceLayer studentServiceLayer;
    @Autowired

    public StudentAPILayer(StudentServiceLayer studentServiceLayer) {
        this.studentServiceLayer = studentServiceLayer;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentServiceLayer.getStudents();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentServiceLayer.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentServiceLayer.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email) {
        studentServiceLayer.updateStudent(studentId,firstname,lastname,email);

    }

}

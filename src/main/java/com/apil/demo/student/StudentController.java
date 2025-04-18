package com.apil.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents()
    {
       return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return student.toString();
    }

    @DeleteMapping(path ="{studentId}")
    public  void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student){
        studentService.updateStudent(studentId,student);
    }
}

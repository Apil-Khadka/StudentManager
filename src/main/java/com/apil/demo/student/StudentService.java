package com.apil.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
   if(!studentRepository.existsById(studentId)) {
       throw new IllegalStateException("student " + studentId+ " does not exist");
   }
       studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId,Student student) {
        if(!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student " + student.getId() + " does not exist");
        }
        Student updateStudent = studentRepository.getStudentById(studentId);
        if(student.getName() != null)
        {
            updateStudent.setName(student.getName());
        }
        if(student.getDob() != null){
            updateStudent.setDob(student.getDob());
        }
        if(student.getEmail() != null)
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            updateStudent.setEmail(student.getEmail());
        }
    }
}

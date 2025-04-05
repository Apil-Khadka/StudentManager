package com.apil.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface  StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);

    Student findStudentsById(Long id);

    Student getStudentById(Long id);
    // Or Query("Select * from Student where email=?)
}

package com.apil.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService
{
    public List<Student> getStudents()
    {
        return List.of(
                new Student(
                        1L,
                        "John Doe",
                        20,
                        LocalDate.of(2003, Month.APRIL, 1),
                        "godHeven@gmail.com"
                )
        );
    }
}

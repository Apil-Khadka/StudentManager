package com.apil.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
         Student Doe =    new Student(
                    "John Doe",
                    LocalDate.of(2003, Month.APRIL, 1),
                    "godHeven@gmail.com"
            );
         Student God = new Student(
                 "God Said",
                 LocalDate.of(2005,Month.SEPTEMBER,4),
                 "godHell@gmail.com"
         );
         studentRepository.saveAll(
                 List.of(Doe,God)
         );
        };
    }
}

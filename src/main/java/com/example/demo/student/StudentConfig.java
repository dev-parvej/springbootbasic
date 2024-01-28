package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student nazneen = new Student(
				1L,
				"Nazneen",
				"naznee@gmail.com",
				LocalDate.of(1996, Month.AUGUST, 13)
			);

            Student parvej = new Student(
				2L,
				"Parvej",
				"parvej@gmail.com",
				LocalDate.of(1996, Month.AUGUST, 13)
			);

            Student abdullah = new Student(
				3L,
				"Abdullah",
				"abullah@gmail.com",
				LocalDate.of(1996, Month.AUGUST, 13)
			);

            

            studentRepository.saveAll(List.of(nazneen, parvej, abdullah));
        };
    }
}
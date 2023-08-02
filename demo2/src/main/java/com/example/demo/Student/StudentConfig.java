package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {

            Student nikoletta = new Student(

                    "Nikoletta",
                    "McKechnie",
                    "nmckechnie0@nsw.gov.au",
                    LocalDate.of(1999, JULY, 21),
                    "Female",
                    "Bislama"

            );
            Student izak = new Student(

                    "Izak",
                    "Imore",
                    "iimore1@columbia.edu",
                    LocalDate.of(1997, OCTOBER,21),
                    "Male",
                    "Burmese"
            );
            Student englebert = new Student(
                    "Englebert",
                    "Ragg",
                    "eragg2@xing.com",
                    LocalDate.of(1995,MARCH,2),
                    "Male",
                    "Bislama"

            );
            Student magdaia = new Student(
                    "Magdaia",
                    "Amiss",
                    "mamiss3@bigcartel.com",
                    LocalDate.of(1995,MARCH,2),
                    "Female",
                    "Spanish"

            );
            Student ben = new Student(
                    "Ben",
                    "Szimoni",
                    "bszimoni4@craigslist.org",
                    LocalDate.of(1995,MARCH,2),
                    "Male",
                    "Tetum"
            );
            Student linette = new Student(
                    "Linette",
                    "Grimm",
                    "grims@email.com",
                    LocalDate.of(1998,AUGUST,19),
                    "Female",
                    "Dutch"
            );
            Student terrel = new Student(
                    "Terrel",
                    "Hurl",
                    "thurl7@phoca.cz",
                    LocalDate.of(1998,MAY,14),
                    "Male",
                    "French"
            );
            Student winona = new Student(
                    "Winona",
                    "Jellico",
                    "wjellico8@fc2.com",
                    LocalDate.of(1998,SEPTEMBER,9),
                    "Female",
                    "English"
            );


            repository.saveAll(
                    List.of(nikoletta,izak,englebert,magdaia,ben,linette,terrel,winona)
            );
        };
    }
}

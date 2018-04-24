package com.student.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentReportApplication.class, args);
    }
}

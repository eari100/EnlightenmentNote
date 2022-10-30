package com.example.enlightenmentNote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class EnlightenmentNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnlightenmentNoteApplication.class, args);
    }

}

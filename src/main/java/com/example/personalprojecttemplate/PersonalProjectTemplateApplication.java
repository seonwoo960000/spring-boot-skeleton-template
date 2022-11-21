package com.example.personalprojecttemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.example.personalprojecttemplate.infrastructure.ApplicationProperties;

import lombok.RequiredArgsConstructor;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class PersonalProjectTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalProjectTemplateApplication.class, args);
    }

}
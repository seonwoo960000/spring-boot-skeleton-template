package com.example.personalprojecttemplate.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static ObjectMapper snakeCaseObjectMapper
            = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    public static <T> T readAndMapToObject(String classpath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new ClassPathResource(classpath).getInputStream(), clazz);
    }

    public static <T> T readAndMapToObjectSnakeCase(String classpath, Class<T> clazz) throws IOException {
        return snakeCaseObjectMapper.readValue(new ClassPathResource(classpath).getInputStream(), clazz);
    }

    public static String readAsString(String classpath) throws IOException {
        return IOUtils.toString(new ClassPathResource(classpath).getInputStream(), StandardCharsets.UTF_8);
    }

    public static String getStringOfLength(int length) {
        return StringUtils.repeat("h", length);
    }

    public static void assertViolationDoesNotExistOn(Validator validator, Object param, String propertyName,
                                                     Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations;
        if (propertyName == null) {
            constraintViolations = validator.validate(param, groups);
        } else {
            constraintViolations = validator.validateProperty(param, propertyName, groups);
        }
        logViolations(constraintViolations);
        assertThat(constraintViolations.size()).isZero();
    }

    public static void assertViolationExistOn(Validator validator, Object param, String propertyName,
                                              Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations;
        if (propertyName == null) {
            constraintViolations = validator.validate(param, groups);
        } else {
            constraintViolations = validator.validateProperty(param, propertyName, groups);
        }
        logViolations(constraintViolations);
        assertThat(constraintViolations.size()).isPositive();
    }

    private static void logViolations(Object constraintViolations) {
        log.info("--------------------------------------------------------------------");
        log.info(constraintViolations.toString());
    }
}

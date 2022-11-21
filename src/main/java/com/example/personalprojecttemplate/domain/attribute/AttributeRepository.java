package com.example.personalprojecttemplate.domain.attribute;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personalprojecttemplate.domain.attribute.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
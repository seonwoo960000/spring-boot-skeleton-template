package com.example.personalprojecttemplate.domain.attribute;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.example.personalprojecttemplate.domain.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "attribute")
public class Attribute extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @Column(name = "account_id", nullable = false) private Long accountId;

    @Column(name = "name", nullable = false, length = 100) private String name;

    @Column(name = "rating", nullable = false) private Integer rating;
}
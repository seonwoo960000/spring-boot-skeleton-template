package com.example.personalprojecttemplate.domain.attribute;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data public class AttributeDto implements Serializable {
    private final Long id;
    private final Long accountId;
    private final String name;
    private final Integer rating;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
}

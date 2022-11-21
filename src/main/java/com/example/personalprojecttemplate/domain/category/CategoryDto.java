package com.example.personalprojecttemplate.domain.category;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
    private final Long accountId;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
}

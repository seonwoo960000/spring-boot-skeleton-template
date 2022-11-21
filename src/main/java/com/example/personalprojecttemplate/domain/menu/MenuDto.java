package com.example.personalprojecttemplate.domain.menu;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

@Data public class MenuDto implements Serializable {
    private final Long id;
    private final Long accountId;
    private final String name;
    private final BigDecimal price;
    private final Long categoryId;
    private final String description;
    private final String imgUrl;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
}

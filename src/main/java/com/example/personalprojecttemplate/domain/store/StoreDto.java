package com.example.personalprojecttemplate.domain.store;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data public class StoreDto implements Serializable {
    private final Long id;
    private final Boolean deleted;
    private final String name;
    private final String description;
    private final String imgUrl;
    private final String phoneNumber;
    private final String facebookUrl;
    private final String instagramUrl;
    private final String email;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
    private final Long storyId;
}

package com.example.personalprojecttemplate.domain.story;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data public class StoryDto implements Serializable {
    private final Long id;
    private final Long accountId;
    private final String title;
    private final String subtitle;
    private final String description;
    private final String imgUrl;
    private final Boolean active;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
}

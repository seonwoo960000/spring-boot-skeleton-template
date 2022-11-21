package com.example.personalprojecttemplate.application.response;

import java.time.Instant;

import lombok.Data;

@Data public class StoryResponse {
    private final String title;
    private final String subtitle;
    private final String description;
    private final String imgUrl;
    private final Boolean active;
}

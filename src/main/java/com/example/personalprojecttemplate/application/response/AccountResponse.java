package com.example.personalprojecttemplate.application.response;

import java.time.Instant;
import java.util.List;

import lombok.Data;

@Data public class AccountResponse {
    private final Long id;
    private final String username;
    private final String password;
    private final String authProvider;
    private final Boolean accountExpired;
    private final Boolean accountLocked;
    private final Instant accountLockedAt;
    private final Boolean credentialExpired;
    private final Boolean enabled;
    private final String name;
    private final String description;
    private final String telEnc;
    private final String pictureUrl;
    private final String email;
    private final String authority;
    private final List<StoryResponse> stories;
}

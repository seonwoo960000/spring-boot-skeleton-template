package com.example.personalprojecttemplate.domain.account;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import com.example.personalprojecttemplate.domain.story.StoryDto;

import lombok.Data;

@Data public class AccountDto implements Serializable {
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
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;

    private final List<StoryDto> stories;
}

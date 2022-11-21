package com.example.personalprojecttemplate.application.request;

import java.time.Instant;

import javax.validation.constraints.NotBlank;

import com.example.personalprojecttemplate.application.request.AccountRequest.CROSS_FIELD_VALIDATION;
import com.example.personalprojecttemplate.application.request.constraint.NameConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@NameConstraint(groups = CROSS_FIELD_VALIDATION.class)
public class AccountRequest {
    public @interface SINGLE_FIELD_VALIDATION {}

    public @interface CROSS_FIELD_VALIDATION {}

    @NotBlank(message = "Must not be null or blank", groups = SINGLE_FIELD_VALIDATION.class)
    String username;
    String password;
    String authProvider;
    Boolean accountExpired;
    Boolean accountLocked;
    Instant accountLockedAt;
    Boolean credentialExpired;
    Boolean enabled;
    String name;
    String description;
    String telEnc;
    String pictureUrl;
    String email;
    String authority;
}

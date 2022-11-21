package com.example.personalprojecttemplate.domain.qr;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data public class QrDto implements Serializable {
    private final Long id;
    private final Long accountId;
    private final String title;
    private final String description;
    private final Instant createdAt;
    private final String createdBy;
    private final Instant modifiedAt;
    private final String modifiedBy;
}

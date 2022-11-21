package com.example.personalprojecttemplate.domain.store;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.personalprojecttemplate.domain.account.Account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Entity @Table(name = "store")
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "account_id", nullable = false) private Account account;

    @Column(name = "deleted", nullable = false) private Boolean deleted = false;

    @Column(name = "name", nullable = false, length = 100) private String name;

    @Column(name = "operating_hours", length = 100) private String operatingHours;

    @Column(name = "description", length = 500) private String description;

    @Column(name = "img_url", length = 2083) private String imgUrl;

    @Column(name = "phone_number", length = 20) private String phoneNumber;

    @Column(name = "facebook_url", length = 2083) private String facebookUrl;

    @Column(name = "instagram_url", length = 2083) private String instagramUrl;

    @Column(name = "email", length = 50) private String email;

    @Column(name = "created_at", nullable = false) private Instant createdAt;

    @Column(name = "created_by", nullable = false, length = 10) private String createdBy;

    @Column(name = "modified_at", nullable = false) private Instant modifiedAt;

    @Column(name = "modified_by", nullable = false, length = 10) private String modifiedBy;

    @Column(name = "story_id") private Long storyId;

}
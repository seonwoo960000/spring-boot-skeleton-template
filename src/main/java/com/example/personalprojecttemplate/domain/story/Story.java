package com.example.personalprojecttemplate.domain.story;

import java.time.Instant;

import javax.persistence.CascadeType;
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

@Data @Entity @Table(name = "story")
public class Story {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @Column(name = "title", nullable = false, length = 100) private String title;

    @Column(name = "subtitle", length = 100) private String subtitle;

    @Column(name = "description", length = 1002) private String description;

    @Column(name = "img_url", length = 2083) private String imgUrl;

    @Column(name = "active", nullable = false) private Boolean active = false;

    @Column(name = "created_at", nullable = false) private Instant createdAt;

    @Column(name = "created_by", nullable = false, length = 10) private String createdBy;

    @Column(name = "modified_at", nullable = false) private Instant modifiedAt;

    @Column(name = "modified_by", nullable = false, length = 10) private String modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn private Account account;
}
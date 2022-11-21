package com.example.personalprojecttemplate.domain.recommendation;

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

import com.example.personalprojecttemplate.domain.store.Store;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Entity @Table(name = "recommendation")
public class Recommendation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "store_id", nullable = false) private Store store;

    @Column(name = "account_id", nullable = false) private Long accountId;

    @Column(name = "title", nullable = false, length = 100) private String title;

    @Column(name = "description", length = 1000) private String description;

    @Column(name = "menu_ids", length = 100) private String menuIds;

    @Column(name = "created_at", nullable = false) private Instant createdAt;

    @Column(name = "created_by", nullable = false, length = 10) private String createdBy;

    @Column(name = "modified_at", nullable = false) private Instant modifiedAt;

    @Column(name = "modified_by", length = 10) private String modifiedBy;

}
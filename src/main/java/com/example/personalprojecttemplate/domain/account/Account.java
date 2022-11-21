package com.example.personalprojecttemplate.domain.account;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.personalprojecttemplate.domain.common.BaseEntity;
import com.example.personalprojecttemplate.domain.story.Story;

import lombok.Data;

@Data @Entity
@Table(name = "account")
@DynamicInsert // insert 시 null 필드 제외
//@DynamicUpdate // update 시 null 필드 제외
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @Column(name = "username", nullable = false, length = 100) private String username;

    @Column(name = "password", length = 200) private String password;

    @Column(name = "auth_provider", nullable = false, length = 20) private String authProvider;

    @Column(name = "account_expired", nullable = false) private Boolean accountExpired = false;

    @Column(name = "account_locked", nullable = false) private Boolean accountLocked = false;

    @Column(name = "account_locked_at") private Instant accountLockedAt;

    @Column(name = "credential_expired", nullable = false) private Boolean credentialExpired = false;

    @Column(name = "enabled", nullable = false) private Boolean enabled = false;

    @Column(name = "name", length = 50) private String name;

    @Column(name = "description", length = 100) private String description;

    @Column(name = "tel_enc", length = 30) private String telEnc;

    @Column(name = "picture_url", length = 300) private String pictureUrl;

    @Column(name = "email", length = 30) private String email;

    @Column(name = "authority", length = 10) private String authority;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY) private List<Story> stories = new ArrayList<>();
}
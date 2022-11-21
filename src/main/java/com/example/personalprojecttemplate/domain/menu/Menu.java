package com.example.personalprojecttemplate.domain.menu;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "menu")
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false) private Long id;

    @Column(name = "account_id", nullable = false) private Long accountId;

    @Column(name = "name", nullable = false, length = 50) private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2) private BigDecimal price;

    @Column(name = "category_id", nullable = false) private Long categoryId;

    @Column(name = "description", length = 1000) private String description;

    @Column(name = "img_url", length = 2083) private String imgUrl;

    @Column(name = "created_at", nullable = false) private Instant createdAt;

    @Column(name = "created_by", nullable = false, length = 10) private String createdBy;

    @Column(name = "modified_at", nullable = false) private Instant modifiedAt;

    @Column(name = "modified_by", nullable = false, length = 10) private String modifiedBy;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getAccountId() {return accountId;}

    public void setAccountId(Long accountId) {this.accountId = accountId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public Long getCategoryId() {return categoryId;}

    public void setCategoryId(Long categoryId) {this.categoryId = categoryId;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getImgUrl() {return imgUrl;}

    public void setImgUrl(String imgUrl) {this.imgUrl = imgUrl;}

    public Instant getCreatedAt() {return createdAt;}

    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}

    public String getCreatedBy() {return createdBy;}

    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}

    public Instant getModifiedAt() {return modifiedAt;}

    public void setModifiedAt(Instant modifiedAt) {this.modifiedAt = modifiedAt;}

    public String getModifiedBy() {return modifiedBy;}

    public void setModifiedBy(String modifiedBy) {this.modifiedBy = modifiedBy;}

}
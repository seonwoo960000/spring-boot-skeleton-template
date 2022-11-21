package com.example.personalprojecttemplate.domain.qr;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personalprojecttemplate.domain.qr.Qr;

public interface QrRepository extends JpaRepository<Qr, Long> {
}
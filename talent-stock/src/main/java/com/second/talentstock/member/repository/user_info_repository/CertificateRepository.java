package com.second.talentstock.member.repository.user_info_repository;

import com.second.talentstock.member.domain.user_info.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}

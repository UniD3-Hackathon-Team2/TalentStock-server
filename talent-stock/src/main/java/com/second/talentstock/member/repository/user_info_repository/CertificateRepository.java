package com.second.talentstock.member.repository.user_info_repository;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Award;
import com.second.talentstock.member.domain.user_info.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByMember(Member member);
}

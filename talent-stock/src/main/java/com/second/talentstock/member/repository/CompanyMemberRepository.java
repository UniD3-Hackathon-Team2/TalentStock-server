package com.second.talentstock.member.repository;

import com.second.talentstock.member.domain.CompanyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMemberRepository extends JpaRepository<CompanyMember, Long> {

}

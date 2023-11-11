package com.second.talentstock.member.repository.user_info_repository;

import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Award;
import com.second.talentstock.member.domain.user_info.ForeignScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignScoreRepository extends JpaRepository<ForeignScore, Long> {
    List<ForeignScore> findByMember(Member member);
}

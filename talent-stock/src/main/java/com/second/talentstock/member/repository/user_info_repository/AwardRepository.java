package com.second.talentstock.member.repository.user_info_repository;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.member.domain.user_info.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findByMember(Member member);
}

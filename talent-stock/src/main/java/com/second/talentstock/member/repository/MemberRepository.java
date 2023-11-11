package com.second.talentstock.member.repository;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.StudentMember;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginIDAndLoginPW(String loginID, String loginPW);
}

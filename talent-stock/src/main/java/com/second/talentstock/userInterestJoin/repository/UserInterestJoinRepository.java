package com.second.talentstock.userInterestJoin.repository;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterestJoinRepository extends JpaRepository<UserInterestJoin, Long> {
    Optional<UserInterestJoin> findByMember(Member member);

    Optional<UserInterestJoin> findByInterestTag(InterestTag interestTag);
}

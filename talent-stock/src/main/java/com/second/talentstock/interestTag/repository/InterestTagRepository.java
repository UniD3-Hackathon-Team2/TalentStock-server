package com.second.talentstock.interestTag.repository;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Award;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterestTagRepository extends JpaRepository<InterestTag, Long> {

    Optional<InterestTag> findByTopCategory(InterestTag topCategory);
}

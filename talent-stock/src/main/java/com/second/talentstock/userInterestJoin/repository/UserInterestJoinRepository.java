package com.second.talentstock.userInterestJoin.repository;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserInterestJoinRepository extends JpaRepository<UserInterestJoin, Long> {

    List<UserInterestJoin> findByMember(Member member);

    List<UserInterestJoin> findByInterestTag(InterestTag interestTag);
}

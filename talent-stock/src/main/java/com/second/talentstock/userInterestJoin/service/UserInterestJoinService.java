package com.second.talentstock.userInterestJoin.service;


import com.second.talentstock.common.BaseException;
import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.interestTag.repository.InterestTagRepository;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import com.second.talentstock.userInterestJoin.repository.UserInterestJoinRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class UserInterestJoinService {

    private final UserInterestJoinRepository userInterestJoinRepository;
    private final MemberRepository memberRepository;
    private final InterestTagRepository interestTagRepository;

    @Transactional
    public void save(UserInterestJoin userInterestJoin) {
        userInterestJoinRepository.save(userInterestJoin);
    }

    public UserInterestJoin findById(Long id) throws BaseException {
        return userInterestJoinRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_ID));
    }

    public UserInterestJoin findByUserId(Long id) throws BaseException {
        Member member = findMemberById(id);
        return userInterestJoinRepository.findByMember(member)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_USER_ID));
    }

    public UserInterestJoin findByInterestId(Long id) throws BaseException {
        InterestTag interestTagById = findInterestTagById(id);
        return userInterestJoinRepository.findByInterestTag(interestTagById)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_INTEREST_ID));
    }

    private Member findMemberById(Long id) throws BaseException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
    }

    private InterestTag findInterestTagById(Long id) throws BaseException {
        return interestTagRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_INTEREST_TAG_ID));
    }
}

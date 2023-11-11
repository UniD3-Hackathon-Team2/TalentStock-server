package com.second.talentstock.member.service;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.common.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member findById(Long id) throws BaseException{
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
    }
}

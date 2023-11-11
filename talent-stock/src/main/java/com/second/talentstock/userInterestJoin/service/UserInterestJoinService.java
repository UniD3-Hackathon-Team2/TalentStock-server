package com.second.talentstock.userInterestJoin.service;


import com.second.talentstock.common.BaseException;
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

    @Transactional
    public void save(UserInterestJoin userInterestJoin) {
        userInterestJoinRepository.save(userInterestJoin);
    }

    public UserInterestJoin findById(Long id) throws BaseException {
        return userInterestJoinRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_ID));
    }

    public UserInterestJoin findByUserId(Long id) throws BaseException {
        return userInterestJoinRepository.findByUserId(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_USER_ID));
    }

    public UserInterestJoin findByInterestId(Long id) throws BaseException {
        return userInterestJoinRepository.findByInterestId(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_INTEREST_JOIN_INTEREST_ID));
    }
}

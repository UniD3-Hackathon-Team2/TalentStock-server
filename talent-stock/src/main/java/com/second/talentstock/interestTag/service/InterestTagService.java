package com.second.talentstock.interestTag.service;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.interestTag.repository.InterestTagReposiroty;
import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_INTEREST_TAG_ID;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_TOP_CATEGORY_TAG_ID;

@Service
@RequiredArgsConstructor
public class InterestTagService {

    private final InterestTagReposiroty interestTagReposiroty;

    @Transactional
    public void Save(InterestTag interestTag) {
        interestTagReposiroty.save(interestTag);
    }

    public InterestTag findById(Long id) throws BaseException {
        return interestTagReposiroty.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_INTEREST_TAG_ID));
    }

    public InterestTag findByTopCategory(Long id) throws BaseException {
        return interestTagReposiroty.findByTopCategory(id)
                .orElseThrow(() -> new BaseException(INVALID_TOP_CATEGORY_TAG_ID));
    }
}

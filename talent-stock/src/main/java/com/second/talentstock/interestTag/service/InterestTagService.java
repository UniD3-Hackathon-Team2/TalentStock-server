package com.second.talentstock.interestTag.service;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.interestTag.repository.InterestTagRepository;
import com.second.talentstock.common.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_INTEREST_TAG_ID;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_TOP_CATEGORY_TAG_ID;

@Service
@RequiredArgsConstructor
public class InterestTagService {

    private final InterestTagRepository interestTagRepository;

    @Transactional
    public void save(InterestTag interestTag) {
        interestTagRepository.save(interestTag);
    }

    public InterestTag findById(Long id) throws BaseException {
        return interestTagRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_INTEREST_TAG_ID));
    }

    public InterestTag findByTopCategory(Long id) throws BaseException {
        InterestTag topCategory = findById(id);
        return interestTagRepository.findByTopCategory(topCategory)
                .orElseThrow(() -> new BaseException(INVALID_TOP_CATEGORY_TAG_ID));
    }
}

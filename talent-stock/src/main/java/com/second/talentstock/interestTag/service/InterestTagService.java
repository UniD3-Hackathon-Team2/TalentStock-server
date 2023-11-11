package com.second.talentstock.interestTag.service;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.interestTag.repository.InterestTagReposiroty;
import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponseStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new BaseException(BaseResponseStatus.INVALID_INTEREST_TAG_ID));
    }
}

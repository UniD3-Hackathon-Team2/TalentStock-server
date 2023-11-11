package com.second.talentstock.offer.service;


import com.second.talentstock.offer.domain.Offer;
import com.second.talentstock.offer.repository.OfferRepository;
import com.second.talentstock.common.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.second.talentstock.common.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    @Transactional
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public Offer findById(Long id) throws BaseException {
        return offerRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_OFFER_ID));
    }

    public Offer findBySenderId(Long id) throws BaseException {
        return offerRepository.findBySenderId(id)
                .orElseThrow(() -> new BaseException(INVALID_SENDER_ID));
    }

    public Offer findByReceiverID(Long id) throws BaseException {
        return offerRepository.findByReceiverId(id)
                .orElseThrow(() -> new BaseException(INVALID_RECIEVER_ID));
    }


}
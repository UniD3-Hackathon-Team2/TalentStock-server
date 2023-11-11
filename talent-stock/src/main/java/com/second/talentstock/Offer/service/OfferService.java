package com.second.talentstock.Offer.service;


import com.second.talentstock.Offer.domain.Offer;
import com.second.talentstock.Offer.repository.OfferRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;

    @Transactional
    public void Save(Offer offer) {
        offerRepository.save(offer);
    }

    public Offer FindBySenderId(Long id) {
        return (Offer) offerRepository.findBySenderId(id)
                .orElseThrow();
    }

    public Offer FindByReceiver(Long id) {
        return (Offer) offerRepository.findByReceiverId(id)
                .orElseThrow();
    }
}

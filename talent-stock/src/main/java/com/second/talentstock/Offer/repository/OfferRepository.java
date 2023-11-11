package com.second.talentstock.Offer.repository;

import com.second.talentstock.Offer.domain.Offer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OfferRepository {

    private static Map<Long, Offer> store = new HashMap<>();
    private static long sequence = 0L;


    public Offer save(Offer offer) {
        offer.setId(++sequence);
        store.put(offer.getId(), offer);
        return offer;
    }


    public Optional<Offer> findBySenderId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Offer> findByReceiverId(Long id) {
        return Optional.ofNullable(store.get(id));
    }

}

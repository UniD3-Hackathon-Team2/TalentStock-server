package com.second.talentstock.Offer.repository;

import com.second.talentstock.Offer.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findBySenderId(Long id);

    Optional<Offer> findByReceiverId(Long id);
}

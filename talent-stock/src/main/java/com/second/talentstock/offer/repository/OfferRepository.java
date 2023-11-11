package com.second.talentstock.offer.repository;

import com.second.talentstock.offer.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findBySenderId(Long id);

    Optional<Offer> findByReceiverId(Long id);
}

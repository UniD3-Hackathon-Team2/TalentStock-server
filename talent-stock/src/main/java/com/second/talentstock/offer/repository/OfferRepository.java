package com.second.talentstock.offer.repository;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.offer.domain.Offer;
import com.second.talentstock.offer.domain.OfferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByReceiver(Member receiver);

    List<Offer> findBySender(Member sender);

    List<Offer> findByReceiverAndOfferType(Member receiver, OfferType offerType);
}

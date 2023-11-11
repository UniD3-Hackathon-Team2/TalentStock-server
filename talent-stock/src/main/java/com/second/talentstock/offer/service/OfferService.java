package com.second.talentstock.offer.service;


import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.offer.domain.Offer;
import com.second.talentstock.offer.dto.MakeOfferReqDto;
import com.second.talentstock.offer.repository.OfferRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_OFFER_ID;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    @Transactional
    public void makeOffer(Long memberId, MakeOfferReqDto reqDto) throws BaseException {
        Member sender = findMemberById(memberId);
        Member receiver = findMemberById(reqDto.getReceiverId());

        Offer offer = Offer.builder()
                .sender(sender)
                .receiver(receiver)
                .offerType(reqDto.getOfferType())
                .build();

        offerRepository.save(offer);
    }

    public Offer findById(Long id) throws BaseException {
        return offerRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_OFFER_ID));
    }

    public List<Offer> findBySenderId(Long id) throws BaseException {
        Member sender = findMemberById(id);
        return offerRepository.findBySender(sender);
    }

    public List<Offer> findByReceiverID(Long id) throws BaseException {
        Member receiver = findMemberById(id);
        return offerRepository.findByReceiver(receiver);
    }

    private Member findMemberById(Long id) throws BaseException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
    }
}
package com.second.talentstock.offer.service;


import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.InvestorMember;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.offer.domain.Offer;
import com.second.talentstock.offer.dto.CompanyReceivedOfferResDto;
import com.second.talentstock.offer.dto.MakeOfferReqDto;
import com.second.talentstock.offer.dto.StockReceivedOfferResDto;
import com.second.talentstock.offer.repository.OfferRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.second.talentstock.common.BaseResponseStatus.*;
import static com.second.talentstock.offer.domain.OfferType.INVEST;
import static com.second.talentstock.offer.domain.OfferType.JOB;
import static com.second.talentstock.offer.dto.CompanyReceivedOfferResDto.CompanyOfferDto;
import static com.second.talentstock.offer.dto.StockReceivedOfferResDto.InvestorOfferDto;

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

    public CompanyReceivedOfferResDto getCompanyReceivedOfferResDto(Long memberId) throws BaseException {
        Member receiver = findMemberById(memberId);
        List<Offer> offerList = offerRepository.findByReceiverAndOfferType(receiver, JOB);

        List<CompanyOfferDto> companyList = offerList.stream().map(
                offer -> {
                    return new CompanyOfferDto((CompanyMember) offer.getSender(), offer);
                }
        ).collect(Collectors.toList());

        return new CompanyReceivedOfferResDto(companyList);
    }

    public StockReceivedOfferResDto getStockReceivedOfferResDto(Long memberId) throws BaseException {
        Member receiver = findMemberById(memberId);
        List<Offer> offerList = offerRepository.findByReceiverAndOfferType(receiver, INVEST);

        List<InvestorOfferDto> investorMemberList = offerList.stream().map(
                offer -> {
                    return new InvestorOfferDto((InvestorMember) offer.getSender(), offer);
                }
        ).collect(Collectors.toList());

        return new StockReceivedOfferResDto(investorMemberList);
    }

    @Transactional
    public void grantOffer(Long memberId, Long offerId) throws BaseException{
        Member member = findMemberById(memberId);
        Offer offer = findById(offerId);
        if (!offer.getReceiver().getId().equals(member.getId())) {
            throw new BaseException(NOT_ALLOW_GRANT_OFFER);
        }
        offer.setChecked(true);
    }
}
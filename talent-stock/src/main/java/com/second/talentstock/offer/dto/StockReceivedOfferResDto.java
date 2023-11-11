package com.second.talentstock.offer.dto;

import com.second.talentstock.member.domain.InvestorMember;
import com.second.talentstock.offer.domain.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockReceivedOfferResDto {

    private int count;
    private List<InvestorOfferDto> investorOfferDtoList;

    public StockReceivedOfferResDto(List<InvestorOfferDto> investorOfferDtoList) {
        this.investorOfferDtoList = investorOfferDtoList;
        this.count = investorOfferDtoList.size();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvestorOfferDto {
        private boolean isGranted;
        private Long offerId;
        private Long investorId;
        private String investorName;
        private int scholarship;

        public InvestorOfferDto(InvestorMember investorMember, Offer offer) {
            this.isGranted = offer.isChecked();
            this.offerId = offer.getId();
            this.investorId = investorMember.getId();
            this.investorName = investorMember.getName();
            this.scholarship = investorMember.getScholarship();
        }
    }
}

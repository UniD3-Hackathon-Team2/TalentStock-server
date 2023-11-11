package com.second.talentstock.offer.dto;

import com.second.talentstock.member.domain.InvestorMember;
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

    public StockReceivedOfferResDto(List<InvestorMember> investorMemberList) {
        this.investorOfferDtoList = investorMemberList.stream().map(
                investorMember -> new InvestorOfferDto(investorMember)
        ).collect(Collectors.toList());
        this.count = investorMemberList.size();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvestorOfferDto {
        private String investorName;
        private int scholarship;

        public InvestorOfferDto(InvestorMember investorMember) {
            this.investorName = investorMember.getName();
            this.scholarship = investorMember.getScholarship();
        }
    }
}

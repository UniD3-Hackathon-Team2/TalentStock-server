package com.second.talentstock.offer.dto;

import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.offer.domain.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyReceivedOfferResDto {
    private int count;
    private List<CompanyOfferDto> companyOfferDtoList;

    public CompanyReceivedOfferResDto(List<CompanyOfferDto> companyMemberList) {
        this.companyOfferDtoList = companyMemberList;
        this.count = companyOfferDtoList.size();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanyOfferDto {
        private boolean isGranted;
        private Long offerId;
        private Long companyId;
        private String companyName;
        private int scholarship;
        private String position;
        private int mustWorkingYear;

        public CompanyOfferDto(CompanyMember companyMember, Offer offer) {
            this.isGranted = offer.isChecked();
            this.offerId = offer.getId();
            this.companyId = companyMember.getId();
            this.scholarship = companyMember.getScholarship();
            this.companyName = companyMember.getName();
            this.position = companyMember.getPosition();
            this.mustWorkingYear = companyMember.getMustWorkingYear();
        }
    }
}

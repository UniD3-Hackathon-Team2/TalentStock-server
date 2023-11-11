package com.second.talentstock.offer.dto;

import com.second.talentstock.member.domain.CompanyMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyReceivedOfferResDto {
    private int count;
    private List<CompanyOfferDto> companyOfferDtoList;

    public CompanyReceivedOfferResDto(List<CompanyMember> companyMemberList) {
        this.companyOfferDtoList = companyMemberList.stream().map(
                companyMember -> new CompanyOfferDto(companyMember)
        ).collect(Collectors.toList());
        this.count = companyOfferDtoList.size();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanyOfferDto {
        private String companyName;
        private String position;
        private int mustWorkingYear;

        public CompanyOfferDto(CompanyMember companyMember) {
            this.companyName = companyMember.getName();
            this.position = companyMember.getPosition();
            this.mustWorkingYear = companyMember.getMustWorkingYear();
        }
    }
}

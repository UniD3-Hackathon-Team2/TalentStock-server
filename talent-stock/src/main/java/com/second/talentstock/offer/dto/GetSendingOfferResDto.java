package com.second.talentstock.offer.dto;

import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.offer.domain.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSendingOfferResDto {
    int count;

    List<SendingOfferResDto> offerList;

    public GetSendingOfferResDto(List<SendingOfferResDto> offerList) {
        this.offerList = offerList;
        this.count = offerList.size();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SendingOfferResDto {
        private boolean granted;
        private Long memberId;
        private String memberName;
        private String interestedIn;
        private String memberUniversity;

        public SendingOfferResDto(StudentMember member, Offer offer, String interest) {
            this.granted = offer.isChecked();
            this.memberId = member.getId();
            this.memberName = member.getName();
            this.interestedIn = interest;
            this.memberUniversity = member.getUniversity();
        }
    }
}

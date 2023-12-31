package com.second.talentstock.offer.dto;

import com.second.talentstock.offer.domain.OfferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakeOfferReqDto {
    private OfferType offerType;
    private Long receiverId;

}

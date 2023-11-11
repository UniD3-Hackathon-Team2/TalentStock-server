package com.second.talentstock.offer.controller;


import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.offer.domain.OfferType;
import com.second.talentstock.offer.dto.MakeOfferReqDto;
import com.second.talentstock.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.second.talentstock.common.BaseResponseStatus.SUCCESS;
import static com.second.talentstock.offer.domain.OfferType.INVEST;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offer")
public class OfferController {
    private final OfferService offerService;

    @PostMapping("")
    public BaseResponse<?> makeOffer(@RequestHeader("Authorization") Long memberId,
                                     @RequestBody MakeOfferReqDto reqDto) {
        try {
            offerService.makeOffer(memberId, reqDto);
            return new BaseResponse<>(SUCCESS);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("")
    public BaseResponse<?> getReceivedOffer(@RequestHeader("Authorization") Long memberId,
                                            @RequestParam("offerType") OfferType offerType) {
        try {
            if (offerType.equals(INVEST)) {
                return new BaseResponse<>(offerService.getStockReceivedOfferResDto(memberId));
            } else {
                return new BaseResponse<>(offerService.getCompanyReceivedOfferResDto(memberId));
            }
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}

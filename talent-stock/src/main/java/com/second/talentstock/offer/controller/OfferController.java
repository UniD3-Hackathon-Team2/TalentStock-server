package com.second.talentstock.offer.controller;


import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.offer.dto.MakeOfferReqDto;
import com.second.talentstock.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.second.talentstock.common.BaseResponseStatus.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offer/")
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

}

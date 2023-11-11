package com.second.talentstock.Offer.controller;


import com.second.talentstock.Offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offer/")
public class OfferController {
    private final OfferService offerService;
}

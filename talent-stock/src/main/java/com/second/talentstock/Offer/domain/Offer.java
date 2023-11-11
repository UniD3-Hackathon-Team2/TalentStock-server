package com.second.talentstock.Offer.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long receiverID;

    private Long senderID;

    private String title;

    private String content;

    @Enumerated(STRING)
    private CheckState isChecked;

    @Enumerated(STRING)
    private OfferType offerType;

}

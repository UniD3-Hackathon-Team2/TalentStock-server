package com.second.talentstock.offer.domain;


import com.second.talentstock.common.BaseEntity;
import com.second.talentstock.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Offer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Member receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Member sender;

    private boolean checked;

    @Enumerated(STRING)
    private OfferType offerType;

    @Builder
    public Offer(Member receiver, Member sender, OfferType offerType) {
        this.checked = false;
        this.receiver = receiver;
        this.sender = sender;
        this.offerType = offerType;
    }
}

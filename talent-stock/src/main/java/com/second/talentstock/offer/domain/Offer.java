package com.second.talentstock.offer.domain;



import com.second.talentstock.member.domain.Member;
import com.second.talentstock.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
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
public class Offer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private Member receiver;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Member sender;

    private Boolean isChecked;

    @Enumerated(STRING)
    private OfferType offerType;

    @Builder
    public Offer(Member receiver, Member sender, OfferType offerType) {
        this.receiver = receiver;
        this.sender = sender;
        this.offerType = offerType;
    }
}

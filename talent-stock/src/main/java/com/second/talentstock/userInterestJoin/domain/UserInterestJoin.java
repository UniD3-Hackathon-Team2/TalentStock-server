package com.second.talentstock.userInterestJoin.domain;

import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class UserInterestJoin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="interest_id")
    private InterestTag interestTag;

}

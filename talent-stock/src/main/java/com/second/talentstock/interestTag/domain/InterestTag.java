package com.second.talentstock.interestTag.domain;



import com.second.talentstock.member.domain.user_info.Award;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class InterestTag {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String tagName;

    @ManyToOne
    @JoinColumn(name="top_category", nullable = true)
    private InterestTag topCategory;

    @OneToMany(mappedBy = "interestTag")
    private List<UserInterestJoin> userInterestJoins = new ArrayList<>();

    public InterestTag(String tagName, InterestTag topCategory, List<UserInterestJoin> userInterestJoins) {
        this.tagName = tagName;
        this.topCategory = topCategory;
        this.userInterestJoins = userInterestJoins;
    }
}

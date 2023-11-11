package com.second.talentstock.member.domain;

import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Setter
@NoArgsConstructor(access = PROTECTED)
public class CompanyMember extends Member {

    private int scholarship;

    private String position;

    private int mustWorkingYear;

    private String positionNeed;

    private String positionExplanation;

    private String explanation;

    private Boolean isCompulsoryWork;


    @Builder
    public CompanyMember(String loginID, String loginPW, MemberType memberType, String name, String email, List<UserInterestJoin> userInterestJoins,
                         String explanation, Boolean isCompulsoryWork, int mustWorkingYear, String positionNeed, String positionExplanation, int scholarship) {
        super(loginID, loginPW, memberType, name, email, userInterestJoins);
        this.explanation = explanation;
        this.isCompulsoryWork = isCompulsoryWork;
        this.mustWorkingYear = mustWorkingYear;
        this.positionNeed = positionNeed;
        this.positionExplanation = positionExplanation;
        this.scholarship = scholarship;
    }
}

package com.second.talentstock.member.domain;

import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import lombok.Setter;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class CompanyMember extends Member {

    private int scholarship;

    private String position;

    private int mustWorkingYear;

    private String positionNeed;

    private String positionExplanation;

    private int scholarship;

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

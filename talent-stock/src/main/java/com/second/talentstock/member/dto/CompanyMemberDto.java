package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.MemberType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompanyMemberDto {

    private MemberType memberType;
    private String name;
    private String email;
    private String explanation;
    private Boolean isCompulsoryWork;
    private int mustWorkingYear;
    private String positionNeed;
    private String positionExplanation;
    private int scholarship;
    private List<String> tagList;


    @Builder
    public CompanyMemberDto(MemberType memberType, String name, String email, String explanation, Boolean isCompulsoryWork, int mustWorkingYear, String positionNeed, String positionExplanation, int scholarship) {
        this.memberType = memberType;
        this.name = name;
        this.email = email;
        this.explanation = explanation;
        this.isCompulsoryWork = isCompulsoryWork;
        this.mustWorkingYear = mustWorkingYear;
        this.positionNeed = positionNeed;
        this.positionExplanation = positionExplanation;
        this.scholarship = scholarship;
    }
}

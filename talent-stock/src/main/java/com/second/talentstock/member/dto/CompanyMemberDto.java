package com.second.talentstock.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyMemberDto {

    private String logoImgUrl;
    private String explanation;
    private Boolean isCompulsoryWork;
    private int mustWorkingYear;
    private String jobTask;

    @Builder
    public CompanyMemberDto(String logoImgUrl, String explanation, Boolean isCompulsoryWork, int mustWorkingYear, String jobTask) {
        this.logoImgUrl = logoImgUrl;
        this.explanation = explanation;
        this.isCompulsoryWork = isCompulsoryWork;
        this.mustWorkingYear = mustWorkingYear;
        this.jobTask = jobTask;
    }
}

package com.second.talentstock.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyMemberDto {

    private int scholarship;
    private String position;
    private int mustWorkingYear;

    @Builder
    public CompanyMemberDto(int scholarship, String position, int mustWorkingYear) {
        this.scholarship = scholarship;
        this.position = position;
        this.mustWorkingYear = mustWorkingYear;
    }
}

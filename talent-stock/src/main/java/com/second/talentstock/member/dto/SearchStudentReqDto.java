package com.second.talentstock.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudentReqDto {
    private String interest;
    private String university;
    private String grade;
    private String department;
}

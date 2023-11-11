package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.StudentMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudentDto {
    private String name;
    private String university;
    private String department;
    private String grade;
    private String shortIntroduce;
    private String interest;

    public SearchStudentDto(StudentMember member) {
        this.name = member.getName();
        this.university = member.getUniversity();
        this.department = member.getDepartment();
        this.grade = member.getGrade() + "";
        this.shortIntroduce = member.getShortIntroduce();
        this.interest = "프론트엔드";
    }
}

package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyMemberReqDto {

    // 필수
    private MemberType memberType;

    // student
    private String university;
    private String department;
    private String grade;
    private Float majorScore;
    private Float totalScore;
    private String shortIntroduce;
    private String introduce;

    // company
    //TODO: 나중에 수정 필요
    private Integer scholarship; // investor
    private String position;
    private Integer mustWorkingYear;

    // common
    private String name;
    private String email;

    public void modifyStudent(StudentMember student) {
        if (university != null) {
            student.setUniversity(university);
        }
        if (department != null) {
            student.setDepartment(department);
        }
        if (grade != null) {
            student.setGrade(grade);
        }
        if (majorScore != null) {
            student.setMajorScore(majorScore);
        }
        if (totalScore != null) {
            student.setTotalScore(totalScore);
        }
        if (shortIntroduce != null) {
            student.setShortIntroduce(shortIntroduce);
        }
        if (introduce != null) {
            student.setIntroduce(introduce);
        }
        if (name != null) {
            student.setName(name);
        }
        if (email != null) {
            student.setEmail(email);
        }
    }

    public void modifyCompany(CompanyMember companyMember) {
        if (name != null) {
            companyMember.setName(name);
        }
        if (email != null) {
            companyMember.setEmail(email);
        }
        if (scholarship != null) {
            companyMember.setScholarship(scholarship);
        }
        if (position != null) {
            companyMember.setPosition(position);
        }
        if (mustWorkingYear != null) {
            companyMember.setMustWorkingYear(mustWorkingYear);
        }
    }

    public void modifyInvestor(InvestorMember investorMember) {
        if (name != null) {
            investorMember.setName(name);
        }
        if (email != null) {
            investorMember.setEmail(email);
        }
        if (scholarship != null) {
            investorMember.setScholarship(scholarship);
        }
    }
}

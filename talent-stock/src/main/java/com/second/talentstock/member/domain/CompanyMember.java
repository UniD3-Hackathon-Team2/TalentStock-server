package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class CompanyMember extends Member {

    private int scholarship;

    private String position;

    private int mustWorkingYear;

    @Builder
    public CompanyMember(String loginID, String loginPW, MemberType memberType, String name, String email,
                         int scholarship, String position, int mustWorkingYear) {
        super(loginID, loginPW, memberType, name, email);
        this.scholarship = scholarship;
        this.position = position;
        this.mustWorkingYear = mustWorkingYear;
    }
}

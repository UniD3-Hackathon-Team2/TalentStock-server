package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StudentMember extends Member {
    private String university;
    private String department;
    private String grade;
    private float majorScore;
    private float totalScore;
    private String shortIntroduce;
    private String introduce;

    @Builder
    public StudentMember(String loginID, String loginPW, MemberType memberType, String name, String email,
                         String university, String department, String grade, float majorScore, float totalScore, String shortIntroduce, String introduce) {
        super(loginID, loginPW, memberType, name, email);
        this.university = university;
        this.department = department;
        this.grade = grade;
        this.majorScore = majorScore;
        this.totalScore = totalScore;
        this.shortIntroduce = shortIntroduce;
        this.introduce = introduce;
    }
}

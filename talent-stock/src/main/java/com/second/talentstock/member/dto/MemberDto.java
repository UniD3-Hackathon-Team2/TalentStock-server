package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.domain.user_info.*;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long id;
    @Enumerated(STRING)
    private MemberType userType;
    private String name;
    private String email;


    private String university;
    private String department;
    private int grade;
    private float majorScore;
    private float totalScore;
    private String shortIntroduce;
    private String introduce;

    private List<Award> awardList;
    private List<Certificate> certificateList;
    private List<ForeignScore> foreignScoreList;
    private List<GroupActivity> groupActivityList;
    private List<Project> projectList;


    private String logoImgUrl;
    private String explanation;
    private Boolean isCompulsoryWork;
    private int mustWorkingYear;
    private String jobTask;

    public MemberDto(Long id, MemberType userType, String name, String email, String university, String department, int grade, float majorScore, float totalScore, String shortIntroduce, String introduce, List<Award> awardList, List<Certificate> certificateList, List<ForeignScore> foreignScoreList, List<GroupActivity> groupActivityList, List<Project> projectList, String logoImgUrl, String explanation, Boolean isCompulsoryWork, int mustWorkingYear, String jobTask) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.university = university;
        this.department = department;
        this.grade = grade;
        this.majorScore = majorScore;
        this.totalScore = totalScore;
        this.shortIntroduce = shortIntroduce;
        this.introduce = introduce;
        this.awardList = awardList;
        this.certificateList = certificateList;
        this.foreignScoreList = foreignScoreList;
        this.groupActivityList = groupActivityList;
        this.projectList = projectList;
        this.logoImgUrl = logoImgUrl;
        this.explanation = explanation;
        this.isCompulsoryWork = isCompulsoryWork;
        this.mustWorkingYear = mustWorkingYear;
        this.jobTask = jobTask;
    }
}

package com.second.talentstock.member.dto;


import com.second.talentstock.member.dto.user_info_Dto.*;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
public class StudentMemberDto {


    private String university;
    private String department;
    private int grade;
    private float majorScore;
    private float totalScore;
    private String shortIntroduce;
    private String introduce;

    private List<AwardDto> awardList;
    private List<CertificateDto> certificateList;
    private List<ForeignScoreDto> foreignScoreList;
    private List<GroupActivityDto> groupActivityList;
    private List<ProjectDto> projectList;


    @Builder
    public StudentMemberDto(String university, String department, int grade, float majorScore, float totalScore, String shortIntroduce, String introduce, List<AwardDto> awardList, List<CertificateDto> certificateList, List<ForeignScoreDto> foreignScoreList, List<GroupActivityDto> groupActivityList, List<ProjectDto> projectList) {
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
    }
}

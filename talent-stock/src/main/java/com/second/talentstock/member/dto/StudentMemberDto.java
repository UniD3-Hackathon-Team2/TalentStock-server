package com.second.talentstock.member.dto;


import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.domain.user_info.*;
import com.second.talentstock.member.dto.user_info_Dto.*;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.EnumType.STRING;


@Data
@NoArgsConstructor
@Setter
@Getter
public class StudentMemberDto {

    @Enumerated(STRING)
    private MemberType memberType;
    private String name;
    private String email;


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


    private List<String> interestTagList;


    @Builder
    public StudentMemberDto(MemberType memberType, String name, String email, String university, String department, int grade,
                            float majorScore, float totalScore, String shortIntroduce, String introduce,
                            List<Award> awardList, List<Certificate> certificateList, List<ForeignScore> foreignScoreList,
                            List<GroupActivity> groupActivityList, List<Project> projectList, List<InterestTag> interestTagList) {
        this.memberType = memberType;
        this.name = name;
        this.email = email;
        this.university = university;
        this.department = department;
        this.grade = grade;
        this.majorScore = majorScore;
        this.totalScore = totalScore;
        this.shortIntroduce = shortIntroduce;
        this.introduce = introduce;
        this.awardList = awardList.stream()
                .map(award -> new AwardDto(award)).collect(Collectors.toList());
        this.certificateList = certificateList.stream()
                .map(certificate -> new CertificateDto(certificate)).collect(Collectors.toList());
        this.foreignScoreList = foreignScoreList.stream()
                .map(foreignScore -> new ForeignScoreDto(foreignScore)).collect(Collectors.toList());
        this.groupActivityList = groupActivityList.stream()
                .map(groupActivity -> new GroupActivityDto(groupActivity)).collect(Collectors.toList());
        this.projectList = projectList.stream()
                .map(project -> new ProjectDto(project)).collect(Collectors.toList());
        this.interestTagList = interestTagList.stream()
                .map(interestTag -> interestTag.getTagName()).collect(Collectors.toList());
    }
}

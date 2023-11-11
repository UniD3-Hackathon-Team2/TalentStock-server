package com.second.talentstock.member.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.member.domain.user_info.*;
import com.second.talentstock.member.dto.CompanyMemberDto;
import com.second.talentstock.member.dto.LoginMemberResDto;
import com.second.talentstock.member.dto.StudentMemberDto;
import com.second.talentstock.member.dto.user_info_Dto.*;
import com.second.talentstock.member.repository.CompanyMemberRepository;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.member.repository.StudentMemberRepository;
import com.second.talentstock.member.repository.user_info_repository.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_LOGIN_INFO;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;
import static jakarta.persistence.FetchType.LAZY;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private StudentMemberRepository studentMemberRepository;
    private CompanyMemberRepository companyMemberRepository;
    private AwardRepository awardRepository;
    private CertificateRepository certificateRepository;
    private ForeignScoreRepository foreignScoreRepository;
    private GroupActivityRepository groupActivityRepository;
    private ProjectRepository projectRepository;

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }


    public LoginMemberResDto findByIdAndPw(String id, String pw) throws BaseException {
        Member member = memberRepository.findByLoginIDAndLoginPW(id, pw)
                .orElseThrow(() -> new BaseException(INVALID_LOGIN_INFO));
        return LoginMemberResDto.builder()
                .memberType(member.getMemberType())
                .memberId(member.getId())
                .build();
    }


    public Member findById(Long id) throws BaseException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
    }


    public MemberType judgeMemberType(Long id) throws BaseException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
        return member.getUserType();
    }

    public StudentMemberDto showStudentProfile(Long id) throws BaseException {
        StudentMember studentMember = studentMemberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));


        Optional<Award> award = awardRepository.findById(id);
        Optional<Certificate> certificate = certificateRepository.findById(id);
        Optional<ForeignScore> foreignScore = foreignScoreRepository.findById(id);
        Optional<GroupActivity> groupActivity = groupActivityRepository.findById(id);
        Optional<Project> project = projectRepository.findById(id);


        AwardDto awardDto = AwardDto.builder()
                .id(award.get().getId())
                .member(award.get().getMember())
                .title(award.get().getTitle())
                .content(award.get().getContent())
                .awardDate(award.get().getAwardDate())
                .build();

        CertificateDto certificateDto = CertificateDto.builder()
                .id(certificate.get().getId())
                .member(certificate.get().getMember())
                .title(certificate.get().getTitle())
                .content(certificate.get().getContent())
                .awardDate(certificate.get().getAwardDate())
                .build();

        ForeignScoreDto foreignScoreDto = ForeignScoreDto.builder()
                .id(foreignScore.get().getId())
                .member(foreignScore.get().getMember())
                .score(foreignScore.get().getScore())
                .type(foreignScore.get().getType())
                .acquisitionDate(foreignScore.get().getAcquisitionDate())
                .build();

        GroupActivityDto groupActivityDto = GroupActivityDto.builder()
                .id(groupActivity.get().getId())
                .member(groupActivity.get().getMember())
                .groupName(groupActivity.get().getGroupName())
                .role(groupActivity.get().getRole())
                .startDate(groupActivity.get().getStartDate())
                .endDate(groupActivity.get().getEndDate())
                .content(groupActivity.get().getContent())
                .build();

        ProjectDto projectDto = ProjectDto.builder()
                .id(project.get().getId())
                .member(project.get().getMember())
                .projectName(project.get().getProjectName())
                .startDate(project.get().getStartDate())
                .endDate(project.get().getEndDate())
                .content(project.get().getContent())
                .role(project.get().getRole())
                .build();

        return StudentMemberDto.builder()
                .department(studentMember.getDepartment())
                .grade(studentMember.getGrade())
                .majorScore(studentMember.getMajorScore())
                .totalScore(studentMember.getTotalScore())
                .shortIntroduce(studentMember.getShortIntroduce())
                .introduce(studentMember.getIntroduce())
                .awardList((List<AwardDto>) awardDto)
                .certificateList((List<CertificateDto>) certificateDto)
                .foreignScoreList((List<ForeignScoreDto>) foreignScoreDto)
                .groupActivityList((List<GroupActivityDto>) groupActivityDto)
                .projectList((List<ProjectDto>) projectDto)
                .build();
    }

    public CompanyMemberDto showCompanyProfile(Long id) throws BaseException {
        CompanyMember companyMember = companyMemberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
        return CompanyMemberDto.builder()
                .logoImgUrl(companyMember.getLogoImgUrl())
                .explanation(companyMember.getExplanation())
                .isCompulsoryWork(companyMember.getIsCompulsoryWork())
                .mustWorkingYear(companyMember.getMustWorkingYear())
                .jobTask(companyMember.getJobTask())
                .build();
    }
}

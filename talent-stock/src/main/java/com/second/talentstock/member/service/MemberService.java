package com.second.talentstock.member.service;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.member.domain.user_info.*;
import com.second.talentstock.member.dto.*;
import com.second.talentstock.member.dto.user_info_Dto.*;
import com.second.talentstock.member.repository.CompanyMemberRepository;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.member.repository.StudentMemberRepository;
import com.second.talentstock.member.repository.user_info_repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_LOGIN_INFO;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final StudentMemberRepository studentMemberRepository;

    private final CompanyMemberRepository companyMemberRepository;
    private final AwardRepository awardRepository;
    private final CertificateRepository certificateRepository;
    private final ForeignScoreRepository foreignScoreRepository;
    private final GroupActivityRepository groupActivityRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }


    public LoginMemberResDto findByIdAndPw(LoginMemberReqDto reqDto) throws BaseException {
        Member member = memberRepository.findByLoginIDAndLoginPW(reqDto.getId(), reqDto.getPw())
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


    public SearchStudentResDto searchStudent(SearchStudentReqDto reqDto) throws BaseException {
        String university = reqDto.getUniversity();
        String grade = reqDto.getGrade();
        String department = reqDto.getDepartment();
        List<StudentMember> studentMemberList;
        if (university == null && grade == null && department == null) {
            studentMemberList = studentMemberRepository.findAll();
        } else if (university == null && grade == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByDepartment(department);
        } else if (university == null && department == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByGrade(grade);
        } else if (grade == null && department == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByUniversity(university);
        } else if (university == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByGradeAndDepartment(grade, department);
        } else if (grade == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByUniversityAndDepartment(university, department);
        } else if (department == null) {
            studentMemberList = studentMemberRepository.findStudentMembersByUniversityAndGrade(university, grade);
        } else {
            studentMemberList = studentMemberRepository.findStudentMembersByUniversityAndGradeAndDepartment(university, grade, department);
        }

        return new SearchStudentResDto(studentMemberList);
    }


    public MemberType judgeMemberType(Long id) throws BaseException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));
        return member.getMemberType();
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
                .grade(Integer.parseInt(studentMember.getGrade()))
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

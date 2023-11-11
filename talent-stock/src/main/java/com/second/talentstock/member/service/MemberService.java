package com.second.talentstock.member.service;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.interestTag.domain.InterestTag;
import com.second.talentstock.interestTag.repository.InterestTagRepository;
import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.member.domain.*;
import com.second.talentstock.member.domain.user_info.*;
import com.second.talentstock.member.dto.*;
import com.second.talentstock.member.repository.CompanyMemberRepository;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.member.repository.StudentMemberRepository;
import com.second.talentstock.member.repository.user_info_repository.*;
import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import com.second.talentstock.userInterestJoin.repository.UserInterestJoinRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_LOGIN_INFO;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;
import static com.second.talentstock.member.domain.MemberType.*;

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

    private final InterestTagRepository interestTagRepository;
    private final UserInterestJoinRepository userInterestJoinRepository;

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

        List<UserInterestJoin> userInterestJoinList = userInterestJoinRepository.findByMember(studentMember);
        List<InterestTag> interestTags = userInterestJoinList.stream().map(
                userInterestJoin -> {
                    return userInterestJoin.getInterestTag();
                }
        ).collect(Collectors.toList());

        return StudentMemberDto.builder()
                .memberType(studentMember.getMemberType())
                .name(studentMember.getName())
                .email(studentMember.getEmail())
                .university(studentMember.getUniversity())
                .department(studentMember.getDepartment())
                .grade(Integer.parseInt(studentMember.getGrade()))
                .majorScore(studentMember.getMajorScore())
                .totalScore(studentMember.getTotalScore())
                .shortIntroduce(studentMember.getShortIntroduce())
                .introduce(studentMember.getIntroduce())
                .awardList(awardRepository.findByMember(studentMember))
                .certificateList(certificateRepository.findByMember(studentMember))
                .foreignScoreList(foreignScoreRepository.findByMember(studentMember))
                .groupActivityList(groupActivityRepository.findByMember(studentMember))
                .projectList(projectRepository.findByMember(studentMember))
                .interestTagList(interestTags)
                .build();
    }

    public CompanyMemberDto showCompanyProfile(Long id) throws BaseException {
        CompanyMember companyMember = companyMemberRepository.findById(id)
                .orElseThrow(() -> new BaseException(INVALID_USER_ID));

        List<UserInterestJoin> userInterestJoinList = userInterestJoinRepository.findByMember(companyMember);
        List<String> interestTags = userInterestJoinList.stream().map(
                userInterestJoin -> {
                    return userInterestJoin.getInterestTag().getTagName();
                }
        ).collect(Collectors.toList());

        CompanyMemberDto dto = CompanyMemberDto.builder()
                .memberType(companyMember.getMemberType())
                .name(companyMember.getName())
                .email(companyMember.getEmail())
                .explanation(companyMember.getPositionExplanation())
                .isCompulsoryWork(companyMember.getIsCompulsoryWork())
                .mustWorkingYear(companyMember.getMustWorkingYear())
                .positionNeed(companyMember.getPosition())
                .positionExplanation(companyMember.getPositionExplanation())
                .scholarship(companyMember.getScholarship())
                .build();

        dto.setTagList(interestTags);

        return dto;
    }

    @Transactional
    public void modifyMember(Long memberId, ModifyMemberReqDto reqDto) throws BaseException{
        if (reqDto.getMemberType().equals(STUDENT)) {
            modifyStudent(memberId, reqDto);
        } else if (reqDto.getMemberType().equals(COMPANY)) {
            modifyCompany(memberId, reqDto);
        } else {
            modifyInvestor(memberId, reqDto);
        }
    }

    private void modifyStudent(Long memberId, ModifyMemberReqDto reqDto) throws BaseException {
        StudentMember student = (StudentMember) findById(memberId);
        reqDto.modifyStudent(student);
    }

    private void modifyCompany(Long memberId, ModifyMemberReqDto reqDto) throws BaseException {
        CompanyMember company = (CompanyMember) findById(memberId);
        reqDto.modifyCompany(company);
    }

    private void modifyInvestor(Long memberId, ModifyMemberReqDto reqDto) throws BaseException {
        InvestorMember investor = (InvestorMember) findById(memberId);
        reqDto.modifyInvestor(investor);
    }
}

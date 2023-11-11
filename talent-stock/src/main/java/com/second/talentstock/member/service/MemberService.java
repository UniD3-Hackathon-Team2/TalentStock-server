package com.second.talentstock.member.service;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.StudentMember;
import com.second.talentstock.member.dto.LoginMemberReqDto;
import com.second.talentstock.member.dto.LoginMemberResDto;
import com.second.talentstock.member.dto.SearchStudentReqDto;
import com.second.talentstock.member.dto.SearchStudentResDto;
import com.second.talentstock.member.repository.MemberRepository;
import com.second.talentstock.member.repository.StudentMemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.second.talentstock.common.BaseResponseStatus.INVALID_LOGIN_INFO;
import static com.second.talentstock.common.BaseResponseStatus.INVALID_USER_ID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final StudentMemberRepository studentMemberRepository;

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
}

package com.second.talentstock.generate_data;

import com.second.talentstock.interestTag.service.InterestTagService;
import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.MemberType;
import com.second.talentstock.member.service.MemberService;
import com.second.talentstock.userInterestJoin.service.UserInterestJoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.second.talentstock.member.domain.MemberType.COMPANY;

@SpringBootTest
public class GenerateTestData {

    @Autowired
    MemberService memberService;

    @Autowired
    InterestTagService interestTagService;

    @Autowired
    UserInterestJoinService userInterestJoinService;

    @Test
    public void generateTestMemberData() throws Exception {
        // 이부분만 변경하기
//        int count = 16;
//        String studentName = "김토성";
//
//        String[] univs = new String[]
//                {"중앙대학교", "성균관대학교", "카이스트", "숙명여자대학교", "포항공과대학교", "고려대학교", "연세대학교"};
//        String[] departments = new String[]
//                {"컴퓨터공학과", "소프트웨어학과", "전산학과", "인공지능학과", "컴퓨터과학과", "사이버보안학과", "응용통계학과",};
//
//        String loginId = "studentid" + count;
//        String loginPw = "studentpw" + count;
//        MemberType memberType = STUDENT;
//        String email = loginId + "@gmail.com";
//
//        String university = univs[(int) (Math.random() * 7)];
//        String department = departments[(int) (Math.random() * 7)];
//
//        int grade = (int) (Math.random() * 2) + 3;
//
//        float majorScore = (float) (Math.round((((float) (Math.random() * 1)) + 2) * 100) / 100.0);
//        float totalScore = majorScore + 0.1f;
//        String shortIntroduce = String.format("안녕하세요. 저는 %s에서 %s을 전공하고 있는 %s입니다. \n" +
//                        "저는 현재 프론트 개발 분야에 관심이 있고, 그와 관련된 분야로 취직하길 희망합니다."
//                , university, department, studentName);
//        String introduce = "프론트 개발 분야에 관심을 가지고 있어서 000 부스트 캠프를 수료하였습니다. \n" +
//                "현재 000 프로젝트에서 플러터를 기반으로 ---앱을 만들고 있습니다. \n" +
//                "해당 프로젝트의 결과물은 다음 링크에서 확인하실 수 있습니다. \n ";
//
//        StudentMember student = StudentMember.builder()
//                .loginID(loginId)
//                .loginPW(loginPw)
//                .memberType(memberType)
//                .name(studentName)
//                .email(email)
//                .university(university)
//                .department(department)
//                .grade(grade+"")
//                .majorScore(majorScore)
//                .totalScore(totalScore)
//                .shortIntroduce(shortIntroduce)
//                .introduce(introduce)
//                .build();
//
//        memberService.save(student);
    }

    @Test
    public void generateTestCompanyData() throws Exception {
//        // 이부분만 변경하기
//        String[] positions = new String[]
//                {"프론트엔드 리액트", "백엔드 스프링", "데이터베이스관리자", "인공지능 연구", "보안 연구"};
//
//        int count = 21;
//
//        for (; count < 30; count++) {
//            String loginId = "companyid" + count;
//            String loginPw = "companypw" + count;
//            MemberType memberType = COMPANY;
//            String name = "회사" + count;
//            String email = loginId + "@gmail.com";
//
//            int scholarShip = (int) (Math.random() * 10000000) + 10000000;
//            String position = positions[(int) (Math.random() * 5)];
//            int mustWorkingYear = (int) (Math.random() * 3) + 2;
//
//            CompanyMember companyMember = CompanyMember.builder()
//                    .loginID(loginId)
//                    .loginPW(loginPw)
//                    .memberType(memberType)
//                    .name(name)
//                    .email(email)
//                    .scholarship(scholarShip)
//                    .position(position)
//                    .mustWorkingYear(mustWorkingYear)
//                    .build();
//
//            memberService.save(companyMember);
//        }
    }

    @Test
    public void generateStudentInterest() throws Exception {

//        InterestTag front = InterestTag.builder()
//                .tagName("프론트엔드")
//                .build();
//        interestTagService.save(front);

//        Long userId = 12l;
//
//        for (; userId < 17; userId++) {
//            Member member = memberService.findById(userId);
//
//            InterestTag tag = interestTagService.findById(1L);
//            UserInterestJoin interest = UserInterestJoin.builder()
//                    .member(member)
//                    .interestTag(tag)
//                    .build();
//
//            userInterestJoinService.save(interest);
//        }
    }
}

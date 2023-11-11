package com.second.talentstock.member.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.common.BaseResponseStatus;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.web.bind.annotation.*;

import static com.second.talentstock.member.domain.MemberType.COMPANY;
import static com.second.talentstock.member.domain.MemberType.STUDENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public BaseResponse<?> login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        try {
            return new BaseResponse(memberService.findByIdAndPw(id, pw));
        } catch (BaseException e) {
            return new BaseResponse(e.getStatus());
        }
    }

    @GetMapping("/profile")
    @ResponseBody
    public BaseResponse<?> profile(@RequestParam("id") Long id) {
        try {
            if (memberService.judgeMemberType(id) == STUDENT) {
                return new BaseResponse(memberService.showStudentProfile(id));
            }
            else if (memberService.judgeMemberType(id) == COMPANY){
                return new BaseResponse(memberService.showCompanyProfile(id));
            }
            else {
                return new BaseResponse(BaseResponseStatus.INVALID_USER_ID);
            }
        } catch (BaseException e) {
            return new BaseResponse(e.getStatus());
        }
    }
}

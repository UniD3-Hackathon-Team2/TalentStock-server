package com.second.talentstock.member.controller;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.member.dto.LoginMemberReqDto;
import com.second.talentstock.member.dto.SearchStudentReqDto;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginMemberReqDto reqDto) {
        try {
            return new BaseResponse(memberService.findByIdAndPw(reqDto));
        } catch (BaseException e) {
            return new BaseResponse(e.getStatus());
        }
    }

    @PostMapping("/search")
    public BaseResponse<?> searchStudent(@RequestBody SearchStudentReqDto reqDto) {
        try {
            return new BaseResponse<>(memberService.searchStudent(reqDto));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}

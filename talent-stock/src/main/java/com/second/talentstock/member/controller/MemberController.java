package com.second.talentstock.member.controller;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

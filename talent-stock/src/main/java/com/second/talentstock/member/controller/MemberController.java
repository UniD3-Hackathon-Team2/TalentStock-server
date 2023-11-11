package com.second.talentstock.member.controller;

import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member/")
public class MemberController {
    private final MemberService memberService;
}

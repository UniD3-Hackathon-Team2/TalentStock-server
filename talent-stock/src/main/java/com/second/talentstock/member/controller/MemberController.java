package com.second.talentstock.member.controller;

import com.second.talentstock.common.BaseException;
import com.second.talentstock.common.BaseResponse;
import com.second.talentstock.member.dto.LoginMemberReqDto;
import com.second.talentstock.member.dto.ModifyMemberReqDto;
import com.second.talentstock.member.dto.SearchStudentReqDto;
import com.second.talentstock.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.second.talentstock.common.BaseResponseStatus.*;
import static com.second.talentstock.member.domain.MemberType.COMPANY;
import static com.second.talentstock.member.domain.MemberType.STUDENT;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PatchMapping("/{memberId}")
    public BaseResponse<?> modifyMember(@PathVariable("memberId") Long memberId,
                                        @RequestHeader("Authorization") Long loginId,
                                        @RequestBody ModifyMemberReqDto reqDto) {
        try {
            if (!memberId.equals(loginId)) {
                throw new BaseException(NOT_ALLOW_MODIFY_USER);
            }
            memberService.modifyMember(memberId, reqDto);
            return new BaseResponse<>(SUCCESS);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
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
          
    @GetMapping("/{userId}")
    public BaseResponse<?> profile(@PathVariable("userId") Long id) {
        try {
            if (memberService.judgeMemberType(id) == STUDENT) {
                return new BaseResponse<>(memberService.showStudentProfile(id));
            }
            else if (memberService.judgeMemberType(id) == COMPANY){
                return new BaseResponse<>(memberService.showCompanyProfile(id));
            }
            else {
                return new BaseResponse<>(BaseResponseStatus.INVALID_USER_ID);
            }
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }


    @GetMapping("/profile")
    @ResponseBody
    public BaseResponse<?> profile(@RequestParam("id") Long id) {
        try {
            if (memberService.judgeMemberType(id) == STUDENT) {
                return new BaseResponse(memberService.showStudentProfile(id));
            } else if (memberService.judgeMemberType(id) == COMPANY) {
                return new BaseResponse(memberService.showCompanyProfile(id));
            } else {
                return new BaseResponse(INVALID_USER_ID);
            }
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());

        }
    }
}

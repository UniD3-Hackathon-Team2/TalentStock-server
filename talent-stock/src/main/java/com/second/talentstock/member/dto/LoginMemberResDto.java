package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.MemberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginMemberResDto {
    private MemberType memberType;
    private Long memberId;

    @Builder
    public LoginMemberResDto(MemberType memberType, Long memberId) {
        this.memberType = memberType;
        this.memberId = memberId;
    }
}

package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
public class GroupActivityDto {

    private Long id;
    private Member member;
    private String groupName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;

    @Builder
    public GroupActivityDto(Long id, Member member, String groupName, String role, LocalDate startDate, LocalDate endDate, String content) {
        this.id = id;
        this.member = member;
        this.groupName = groupName;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
    }
}

package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.GroupActivity;
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
    private String groupName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;

    @Builder
    public GroupActivityDto(String groupName, String role, LocalDate startDate, LocalDate endDate, String content) {
        this.groupName = groupName;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
    }

    public GroupActivityDto(GroupActivity groupActivity) {
        this.groupName = groupActivity.getGroupName();
        this.role = groupActivity.getRole();
        this.startDate = groupActivity.getStartDate();
        this.endDate = groupActivity.getEndDate();
        this.content = groupActivity.getContent();
    }
}

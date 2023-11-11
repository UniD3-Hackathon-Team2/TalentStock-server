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
public class ProjectDto {

    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private String role;

    @Builder
    public ProjectDto(Long id, Member member, String projectName, LocalDate startDate, LocalDate endDate, String content, String role) {
        this.id = id;
        this.member = member;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.role = role;
    }
}

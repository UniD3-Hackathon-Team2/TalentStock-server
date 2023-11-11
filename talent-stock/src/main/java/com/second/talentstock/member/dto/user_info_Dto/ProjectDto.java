package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Project;
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
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private String role;

    @Builder
    public ProjectDto(String projectName, LocalDate startDate, LocalDate endDate, String content, String role) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.role = role;
    }

    public ProjectDto(Project project) {
        this.projectName = project.getProjectName();
        this.startDate = project.getStartDate();
        this.endDate = project.getEndDate();
        this.content = project.getContent();
        this.role = project.getRole();
    }
}

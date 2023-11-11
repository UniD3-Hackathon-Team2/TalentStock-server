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
public class AwardDto {
    private Long id;
    private Member member;
    private String title;
    private String content;
    private LocalDate awardDate;

    @Builder
    public AwardDto(Long id, Member member, String title, String content, LocalDate awardDate) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.awardDate = awardDate;
    }
}

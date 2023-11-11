package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Award;
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
    private String title;
    private String content;
    private LocalDate awardDate;

    @Builder
    public AwardDto(String title, String content, LocalDate awardDate) {
        this.title = title;
        this.content = content;
        this.awardDate = awardDate;
    }

    public AwardDto(Award award) {
        this.title = award.getTitle();
        this.content = award.getContent();
        this.awardDate = award.getAwardDate();
    }
}

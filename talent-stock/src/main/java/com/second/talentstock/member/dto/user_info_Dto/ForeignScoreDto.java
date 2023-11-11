package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.ForeignScore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
public class ForeignScoreDto {
    private String score;
    private String type;
    private LocalDate acquisitionDate;

    @Builder
    public ForeignScoreDto(String score, String type, LocalDate acquisitionDate) {
        this.score = score;
        this.type = type;
        this.acquisitionDate = acquisitionDate;
    }

    public ForeignScoreDto(ForeignScore foreignScore) {
        this.score = foreignScore.getScore();
        this.type = foreignScore.getType();
        this.acquisitionDate = foreignScore.getAcquisitionDate();
    }
}

package com.second.talentstock.member.dto.user_info_Dto;

import com.second.talentstock.member.domain.Member;
import com.second.talentstock.member.domain.user_info.Certificate;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
public class CertificateDto {
    private String title;
    private String content;
    private LocalDate awardDate;

    @Builder
    public CertificateDto(String title, String content, LocalDate awardDate) {
        this.title = title;
        this.content = content;
        this.awardDate = awardDate;
    }

    public CertificateDto(Certificate certificate) {
        this.title = certificate.getTitle();
        this.content = certificate.getContent();
        this.awardDate = certificate.getAwardDate();
    }
}

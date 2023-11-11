package com.second.talentstock.member.domain.user_info;

import com.second.talentstock.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Award {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member")
    private Member member;

    private String title;

    private String content;

    private LocalDate awardDate;

    @Builder
    public Award(Member member, String title, String content, LocalDate awardDate) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.awardDate = awardDate;
    }
}

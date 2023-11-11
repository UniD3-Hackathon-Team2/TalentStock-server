package com.second.talentstock.member.domain.user_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Award {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDate awardDate;
}

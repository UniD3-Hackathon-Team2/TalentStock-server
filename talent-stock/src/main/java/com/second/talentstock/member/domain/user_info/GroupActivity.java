package com.second.talentstock.member.domain.user_info;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class GroupActivity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String groupName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
}

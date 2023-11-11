package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class CompanyMember extends Member {

    private int scholarship;

    private String position;

    private int mustWorkingYear;
}

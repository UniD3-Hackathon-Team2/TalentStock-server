package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class CompanyMember extends Member {
    private String logoImgUrl;

    private String name;

    private String explanation;

    private Boolean isCompulsoryWork;

    private int mustWorkingYear;

    private String jobTask;
}

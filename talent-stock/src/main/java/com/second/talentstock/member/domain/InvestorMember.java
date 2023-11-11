package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class InvestorMember extends Member {
    private int scholarship;
}

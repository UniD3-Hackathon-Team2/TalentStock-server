package com.second.talentstock.member.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestorMember extends Member {
    private int scholarship;
}

package com.second.talentstock.member.domain;


import com.second.talentstock.common.BaseEntity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String loginID;

    private String loginPW;

    @Enumerated(STRING)
    private MemberType memberType;

    private String name;

    private String email;

    protected Member(String loginID, String loginPW, MemberType memberType, String name, String email) {
        this.loginID = loginID;
        this.loginPW = loginPW;
        this.memberType = memberType;
        this.name = name;
        this.email = email;
    }
}

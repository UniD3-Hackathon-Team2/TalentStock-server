package com.second.talentstock.member.domain;


import com.second.talentstock.common.BaseEntity;

import com.second.talentstock.userInterestJoin.domain.UserInterestJoin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

@Getter
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

    @OneToMany(mappedBy = "member")
    private List<UserInterestJoin> userInterestJoins = new ArrayList<>();


    public Member(String loginID, String loginPW, MemberType memberType, String name, String email, List<UserInterestJoin> userInterestJoins) {
        this.loginID = loginID;
        this.loginPW = loginPW;
        this.memberType = memberType;
        this.name = name;
        this.email = email;
        this.userInterestJoins = userInterestJoins;
    }
}

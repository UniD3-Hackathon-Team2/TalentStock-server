package com.second.talentstock.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class User {

    private Long id;

    private String loginID;

    private String loginPW;

    private String userType;

    private String name;

    private String email;

}

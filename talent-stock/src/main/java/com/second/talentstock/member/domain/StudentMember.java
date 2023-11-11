package com.second.talentstock.member.domain;

  
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import com.second.talentstock.member.domain.user_info.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StudentMember extends Member {
    private String university;
    private String department;
    private int grade;
    private float majorScore;
    private float totalScore;
    private String shortIntroduce;
    private String introduce;
  
    @OneToMany(mappedBy = "member")
    private List<Award> awards = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<ForeignScore> foreignScores = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<GroupActivity> groupActivities = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Project> projects = new ArrayList<>();

}

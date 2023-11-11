package com.second.talentstock.interestTag.domain;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class InterestTag {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String tagName;

    @ManyToOne
    @JoinColumn(name="top_category", nullable = true)
    private InterestTag topCategory;
}

package com.second.talentstock.interestTag.repository;


import com.second.talentstock.interestTag.domain.InterestTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestTagReposiroty extends JpaRepository<InterestTag, Long> {

}

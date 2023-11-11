package com.second.talentstock.interestTag.repository;


import com.second.talentstock.interestTag.domain.InterestTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterestTagReposiroty extends JpaRepository<InterestTag, Long> {

    Optional<InterestTag> findByTopCategory(Long id);
}

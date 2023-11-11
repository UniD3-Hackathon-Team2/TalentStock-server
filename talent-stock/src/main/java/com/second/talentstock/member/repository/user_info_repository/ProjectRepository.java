package com.second.talentstock.member.repository.user_info_repository;

import com.second.talentstock.member.domain.CompanyMember;
import com.second.talentstock.member.domain.user_info.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
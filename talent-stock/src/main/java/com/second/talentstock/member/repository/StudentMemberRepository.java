package com.second.talentstock.member.repository;

import com.second.talentstock.member.domain.StudentMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentMemberRepository extends JpaRepository<StudentMember, Long> {

}

package com.second.talentstock.member.repository;

import com.second.talentstock.member.domain.StudentMember;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentMemberRepository extends JpaRepository<StudentMember, Long> {
    List<StudentMember> findStudentMembersByUniversityAndGradeAndDepartment(String university,
                                                                            String grade,
                                                                            String department);

    List<StudentMember> findStudentMembersByUniversityAndGrade(String university,
                                                               String grade);

    List<StudentMember> findStudentMembersByUniversityAndDepartment(String university,
                                                                    String department);

    List<StudentMember> findStudentMembersByGradeAndDepartment(String grade,
                                                               String department);

    List<StudentMember> findStudentMembersByUniversity(String university);

    List<StudentMember> findStudentMembersByGrade(String grade);

    List<StudentMember> findStudentMembersByDepartment(String department);
}

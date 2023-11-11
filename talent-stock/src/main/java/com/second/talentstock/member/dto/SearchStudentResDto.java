package com.second.talentstock.member.dto;

import com.second.talentstock.member.domain.StudentMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudentResDto {
    int count;
    List<SearchStudentDto> studentDtoList;

    public SearchStudentResDto(List<StudentMember> studentMemberList) {
        this.studentDtoList = studentMemberList.stream().map(
                studentMember -> new SearchStudentDto(studentMember)
        ).collect(Collectors.toList());
        this.count = studentDtoList.size();
    }
}

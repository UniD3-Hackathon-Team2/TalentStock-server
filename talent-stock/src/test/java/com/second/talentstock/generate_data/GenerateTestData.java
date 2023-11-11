package com.second.talentstock.generate_data;

import com.second.talentstock.TalentStockApplication;
import com.second.talentstock.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TalentStockApplication.class)
public class GenerateTestData {

    @Autowired
    MemberService memberService;

    @Test
    public void generateTestMemberData() throws Exception {
        
    }
}

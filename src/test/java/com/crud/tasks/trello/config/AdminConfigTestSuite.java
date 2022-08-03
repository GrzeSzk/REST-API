package com.crud.tasks.trello.config;

import com.crud.tasks.config.AdminConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AdminConfigTestSuite {

    @Autowired
    AdminConfig adminConfig;

    @Test
    public void getterShouldBeNullTest() {
        //Given
        adminConfig = new AdminConfig();
        //When
        String adminMail = adminConfig.getAdminMail();
        //Then
        assertNull(adminMail);
    }
}

package com.crud.tasks.trello.config;

import com.crud.tasks.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void getterShouldBeNullTest() {
        //Given
        trelloConfig = new TrelloConfig();
        //When
        String token = trelloConfig.getTrelloToken();
        String key = trelloConfig.getTrelloAppKey();
        String user = trelloConfig.getTrelloUser();
        String endpoint = trelloConfig.getTrelloApiEndpoint();
        //Then
        assertNull(token);
        assertNull(key);
        assertNull(user);
        assertNull(endpoint);
    }
}

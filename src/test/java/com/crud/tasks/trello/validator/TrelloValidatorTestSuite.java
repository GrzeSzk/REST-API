package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloValidatorTestSuite {

    @Autowired
    TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoardsTest() {
        //Given
        trelloValidator = new TrelloValidator();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Test Board no1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "Test Board no2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("3", "Test Board no3", new ArrayList<>()));
        //When
        List<TrelloBoard> resultList = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(3, resultList.size());
        assertEquals("Test Board no2", resultList.get(1).getName());
    }

    @Test
    void validateCardTest() {
        //Given
        trelloValidator = new TrelloValidator();
        TrelloCard trelloCard = new TrelloCard("Name","Desc", "Pos", "21");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then
        assertEquals("Name", trelloCard.getName());
    }
}

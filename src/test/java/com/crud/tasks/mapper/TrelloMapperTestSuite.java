package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "CardDto", "For tests", "1", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("CardDto", trelloCard.getName());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Card", "For tests", "2", "2");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Card", trelloCardDto.getName());
        assertEquals("2", trelloCardDto.getPos());

    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("3", "ListDto", true);
        List<TrelloListDto> trelloListDtos= new ArrayList<>();
        trelloListDtos.add(trelloListDto);
        //When
        List<TrelloList> testTrelloList = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertEquals("3", testTrelloList.get(0).getId());
        assertTrue(testTrelloList.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("4", "List", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        //When
        List<TrelloListDto> testTrelloListDto = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals("List", testTrelloListDto.get(0).getName());
        assertTrue(testTrelloListDto.get(0).isClosed());
    }

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("5", "ListDto", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("6", "BoardDto", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("BoardDto", trelloBoards.get(0).getName());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("7", "List", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("8", "Board", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardDtos =trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals("Board", trelloBoardDtos.get(0).getName());
    }
}

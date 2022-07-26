package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloService trelloService;

    @GetMapping("boards")
    public ResponseEntity<List<TrelloBoardDto>> getTrelloBoards() {
        return ResponseEntity.ok(trelloService.fetchTrelloBoards());
    }

    @PostMapping("cards")
    public ResponseEntity<CreatedTrelloCard> createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return ResponseEntity.ok(trelloService.createTrelloCard(trelloCardDto));
    }

//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        List<TrelloBoardDto> filteredBoards = trelloBoards.stream()
//                        .filter(trelloBoardDto -> Objects.nonNull(trelloBoardDto.getId()) && Objects.nonNull(trelloBoardDto.getName()))
//                        .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
//                        .collect(Collectors.toList());
//        trelloBoards.forEach(trelloBoardDto -> {
//            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
//        });
//    }

}

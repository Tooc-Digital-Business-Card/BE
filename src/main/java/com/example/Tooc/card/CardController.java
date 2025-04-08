package com.example.Tooc.card;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/card")
@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/{uuid}")
    public ResponseEntity<CardDTO> saveCard(@PathVariable String uuid,
                                            @RequestBody CardDTO cardDTO) {
        return ResponseEntity.ok(cardService.saveCard(uuid, cardDTO));
    }
}

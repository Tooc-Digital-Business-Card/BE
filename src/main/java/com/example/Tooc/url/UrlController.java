package com.example.Tooc.url;

import com.example.Tooc.card.CardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUrlResponseDTO> creatDesignUrl() {
        return ResponseEntity.ok(urlService.createDesignUrl());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CardDTO> getCardByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(urlService.getCardByUuid(uuid));
    }
}

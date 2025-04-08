package com.example.Tooc.url;

import com.example.Tooc.card.Card;
import com.example.Tooc.card.CardDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    // UUID 생성
    public CreateUrlResponseDTO createDesignUrl() {
        String uuid = UUID.randomUUID().toString();

        Url url = Url.builder()
                .uuid(uuid)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(24))
                .isActive(true)
                .build();

        urlRepository.save(url);
        return new CreateUrlResponseDTO(uuid, "/design/" + uuid);
    }

    // UUID로 조회
    public CardDTO getCardByUuid(String uuid) {
        Url url = urlRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("URL을 찾을 수 없습니다"));

        Card card = url.getCard();
        return new CardDTO(card);
    }
}

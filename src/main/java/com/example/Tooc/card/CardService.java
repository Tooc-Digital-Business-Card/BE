package com.example.Tooc.card;

import com.example.Tooc.url.Url;
import com.example.Tooc.url.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardService {

    private final UrlRepository urlRepository;
    private final CardRepository cardRepository;

    public CardService(UrlRepository urlRepository, CardRepository cardRepository) {
        this.urlRepository = urlRepository;
        this.cardRepository = cardRepository;
    }

    public CardDTO saveCard(String uuid, CardDTO cardDTO) {
        Url url = urlRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("URL을 찾을 수 없습니다."));

        Card card = Card.builder()
                .name(cardDTO.getName())
                .univ(cardDTO.getUniv())
                .major(cardDTO.getMajor())
                .studentNumber(cardDTO.getStudentNumber())
                .position(cardDTO.getPosition())
                .affiliation(cardDTO.getAffiliation())
                .phoneNumber(cardDTO.getPhoneNumber())
                .email(cardDTO.getEmail())
                .templateType(cardDTO.getTemplateType())
                .designJson(cardDTO.getDesignJson())
                .build();

        cardRepository.save(card);

        // URL과 연결
        url.setCard(card);
        url.setUpdatedAt(LocalDateTime.now());
        urlRepository.save(url);

        return new CardDTO(card);
    }
}

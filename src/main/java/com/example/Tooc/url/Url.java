package com.example.Tooc.url;

import com.example.Tooc.card.Card;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
    private Boolean isActive;
}

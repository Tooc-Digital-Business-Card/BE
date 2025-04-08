package com.example.Tooc.card;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String univ;
    private String major;
    private String studentNumber;
    private String position;
    private String affiliation;
    private String phoneNumber;
    private String email;
    private String templateType;

    @Lob
    private String designJson;

}

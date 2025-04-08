package com.example.Tooc.card;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardDTO {

    private String name;
    private String univ;
    private String major;
    private String studentNumber;
    private String position;
    private String affiliation;
    private String phoneNumber;
    private String email;
    private String templateType;
    private String designJson;

    public CardDTO(Card card) {
        this.name = card.getName();
        this.univ = card.getUniv();
        this.major = card.getMajor();
        this.studentNumber = card.getStudentNumber();
        this.position = card.getPosition();
        this.affiliation = card.getAffiliation();
        this.phoneNumber = card.getPhoneNumber();
        this.email = card.getEmail();
        this.templateType = card.getTemplateType();
        this.designJson = card.getDesignJson();
    }
}

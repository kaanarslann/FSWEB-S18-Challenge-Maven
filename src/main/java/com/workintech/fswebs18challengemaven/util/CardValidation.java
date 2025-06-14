package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

import java.util.List;


public class CardValidation {
    public static void validate(Card card) {
        if(card.getValue() != null && card.getType() != null) {
            throw new CardException("Card cannot have a value and type at the same time", HttpStatus.BAD_REQUEST);
        }

        if(card.getType() == Type.JOKER) {
            if(card.getValue() != null || card.getColor() != null) {
                throw new CardException("Joker Card's value and color must be null", HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void validateCardList(List<Card> cards) {
        if (cards.isEmpty()) {
            throw new CardException("Card not found", HttpStatus.NOT_FOUND);
        }
    }
}

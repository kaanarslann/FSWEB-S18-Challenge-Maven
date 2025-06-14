package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController {

    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getByColor(@PathVariable("color") String color) {
        List<Card> result = cardRepository.findByColor(color);
        return result;
    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        CardValidation.validate(card);
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card) {
        CardValidation.validate(card);
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card delete(@PathVariable("id") Long id) {
        return cardRepository.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getByValue(@PathVariable("value") Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getByType(@PathVariable("type") String type) {
        return cardRepository.findByType(type);
    }
}

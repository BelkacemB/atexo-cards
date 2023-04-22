package com.job.cards.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.cards.model.Card;
import com.job.cards.services.CardService;

@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @CrossOrigin
    @GetMapping("/cards")
    public Card[] getCards() {
        return cardService.getAllCards();
    }

    @CrossOrigin
    @GetMapping("/cards/hand/new")
    public Card[] getNewHand() {
        cardService.shuffle();
        return cardService.getCurrentHand();
    }

    @CrossOrigin
    @GetMapping("/cards/hand")
    public Card[] getCurrentHand() {
        return cardService.getCurrentHand();
    }

    @CrossOrigin
    @GetMapping("/cards/suit-order")
    public List<Card.Suit> getSuitOrder() {
        return cardService.getSuitOrder();
    }

    @CrossOrigin
    @GetMapping("/cards/value-order")
    public List<Card.Value> getValueOrder() {
        return cardService.getValueOrder();
    }

    @CrossOrigin
    @GetMapping("/cards/hand/sorted")
    public Card[] getSortedCards() {
        return cardService.getSortedHand();
    }

}

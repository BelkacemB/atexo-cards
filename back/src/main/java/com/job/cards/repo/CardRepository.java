package com.job.cards.repo;

import org.springframework.stereotype.Repository;

import com.job.cards.model.Card;

@Repository
public class CardRepository {

    private Card[] cards;

    public CardRepository() {
        this.cards = generateCards();
    }

    private Card[] generateCards() {
        Card[] cards = new Card[52];
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards[i++] = new Card(suit, value);
            }
        }
        return cards;
    }

    public Card[] getCards() {
        return cards;
    }

}
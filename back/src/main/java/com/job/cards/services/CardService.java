package com.job.cards.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.cards.model.Card;
import com.job.cards.repo.CardRepository;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    private static Card[] currentHand;

    private List<Card.Suit> suitOrder = new ArrayList<Card.Suit>();
    private List<Card.Value> valueOrder = new ArrayList<Card.Value>();

    public void shuffle() {
        currentHand = getRandomCards();
        createRandomSuitOrder();
        createRandomValueOrder();
    }

    public Card[] getAllCards() {
        return cardRepository.getCards();
    }

    public Card[] getCurrentHand() {
        return currentHand;
    }

    public List<Card.Suit> getSuitOrder() {
        return suitOrder;
    }

    public List<Card.Value> getValueOrder() {
        return valueOrder;
    }

    private Card[] getRandomCards() {
        Card[] cards = getAllCards();
        Collections.shuffle(Arrays.asList(cards));
        return Arrays.copyOf(cards, 10);
    }

    private void createRandomSuitOrder() {
        Card.Suit[] suits = Card.Suit.values();
        Collections.shuffle(Arrays.asList(suits));
        suitOrder = Arrays.asList(suits);
    }

    private void createRandomValueOrder() {
        Card.Value[] values = Card.Value.values();
        Collections.shuffle(Arrays.asList(values));
        valueOrder = Arrays.asList(values);
    }

    private Comparator<Card> cardComparator = new Comparator<Card>() {
        @Override
        public int compare(Card card1, Card card2) {
            int suit1 = suitOrder.indexOf(card1.getSuit());
            int suit2 = suitOrder.indexOf(card2.getSuit());
            int value1 = valueOrder.indexOf(card1.getValue());
            int value2 = valueOrder.indexOf(card2.getValue());

            if (suit1 != suit2) {
                return suit1 - suit2;
            } else {
                return value1 - value2;
            }
        }
    };

    public Card[] getSortedHand() {
        if (currentHand == null) {
            return new Card[0];
        }
        Card[] sortedHand = Arrays.copyOf(currentHand, currentHand.length);
        Arrays.sort(sortedHand, cardComparator);
        return sortedHand;
    };

}

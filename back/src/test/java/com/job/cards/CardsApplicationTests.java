package com.job.cards;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.job.cards.model.Card;
import com.job.cards.repo.CardRepository;
import com.job.cards.services.CardService;

@SpringBootTest
class CardsApplicationTests {

	@Autowired
	CardRepository cardRepository;

	@Autowired
	CardService cardService;

	@Test
	void testDeckSize() {
		Card[] cards = cardRepository.getCards();
		assert(cards.length == 52);
	}

	@Test
	void testHandSize() {
		cardService.shuffle();
		Card[] cards = cardService.getCurrentHand();
		assert(cards.length == 10);
	}

	@Test
	void testSameCards() {
		cardService.shuffle();
		Card[] currentHand = cardService.getCurrentHand();
		Card[] sortedHand = cardService.getSortedHand();
		for (Card card : currentHand) {
			assert(Arrays.asList(sortedHand).contains(card));
		}
	}

}

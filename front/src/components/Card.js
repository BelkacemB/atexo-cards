import React from "react";

const map = new Map([
    ["TWO", "2"],
    ["THREE", "3"],
    ["FOUR", "4"],
    ["FIVE", "5"],
    ["SIX", "6"],
    ["SEVEN", "7"],
    ["EIGHT", "8"],
    ["NINE", "9"],
    ["TEN", "10"],
    ["JACK", "J"],
    ["QUEEN", "Q"],
    ["KING", "K"],
    ["ACE", "A"],
    ["CLUBS", "♣"],
    ["DIAMONDS", "♦"],
    ["HEARTS", "♥"],
    ["SPADES", "♠"],
    ]);

const colorMap = new Map([
    ["CLUBS", "black"],
    ["DIAMONDS", "red"],
    ["HEARTS", "red"],
    ["SPADES", "black"],
    ]);

function Card({ card }) {
  return (
  <div style={{ color: colorMap.get(card.suit) ?? 'black', border: `1px solid ${colorMap.get(card.suit) ?? 'black'}`, padding: '5px', margin: '5px' }}>
    {map.get(card.value)?? ''}{map.get(card.suit) ?? ''}
  </div>);
}

export default Card;

package miniPoker;

import playingCards.Card;

import java.util.ArrayList;

public class PokerHand {
    ArrayList<Card> cards = new ArrayList<Card>();
    public void addCard(Card card) {
        cards.add(card);
    }
    public int getValue() {
        if (cards.size() == 2) {
            Card highCard, lowCard;
            if (cards.get(0).getValue() > cards.get(1).getValue()) {
                highCard = cards.get(0);
                lowCard = cards.get(1);
            } else {
                highCard = cards.get(1);
                lowCard = cards.get(0);
            }
            int value = highCard.getValue() * 14 + lowCard.getValue();
            if (cards.get(0).getRank() == (cards.get(1).getRank())) {
                value += 1000;

            } else if (cards.get(0).getSuit() == (cards.get(1).getSuit())) {
                value += 500;
            } else {
                value += 0;
            }
            return value;
        } else return 0;
    }

    public void printHand() {
        System.out.println(cards.get(0).getShortName());
        System.out.println(cards.get(1).getShortName());
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + cards +
                '}';
    }
}

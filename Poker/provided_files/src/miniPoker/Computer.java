package miniPoker;

import playingCards.Card;
import playingCards.Rank;
import playingCards.Suit;

public class Computer {
    PokerHand hand = new PokerHand();

    public Computer() {
    }

    public int getValue() {
        return hand.getValue();
    }

    public void newHand() {
        hand = new PokerHand();
    }

    public void printHand() {
        hand.printHand();
    }

    public boolean stand() {
        Rank r1 = hand.cards.get(0).getRank();
        Rank r2 = hand.cards.get(1).getRank();
        Suit s1 = hand.cards.get(0).getSuit();
        Suit s2 = hand.cards.get(1).getSuit();
        if (r1 != r2 && s1!=s2) {
            if (r1.getValue() + r2.getValue() >= 23) return true;
            else return false;
        } else return true;
    }

    public void takeCard(Card card) {
        hand.addCard(card);
    }

}
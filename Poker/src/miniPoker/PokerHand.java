
package miniPoker;

import playingCards.Card;

import java.util.ArrayList;

/**
 * This class creates an object which represents two cards that are played in every hand by each player.
 * It has features to add the cards,get the category of hands,print the card value.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */


public class PokerHand {
    private final ArrayList<Card> cardList = new ArrayList<>();
    private static final int PAIR_SCALE_VALUE = 1000;
    private static final int FLUSH_SCALE_VALUE = 500;
    public static final int HIGH_CARD_MULTIPLIER = 14;

    public PokerHand() {

    }

    public void printHand() {
        System.out.println(this);
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    /**
     * Categorizes the hand into pair, flush or high card based on card value.
     * @return the String representing the category of the card.
     */
    private String getHandsCategory() {
        return this.cardList.get(0).getRank() == this.cardList.get(1).getRank() ? "Pair" :
                this.cardList.get(0).getSuit() == this.cardList.get(1).getSuit() ? "Flush" : "High Card";
    }

    /**
     * Calculates total value of hand as per the provided logic.
     * @return Total Value of hand.
     */
    public int getValue() {
        if (this.cardList.isEmpty()) {
            return 0;
        }
        return this.getPokerHandValue(this.cardList.get(0), this.cardList.get(1));
    }

    /**
     * Base logic for the calculating the hand value
     * @param firstCard: Card1 of the poker hand
     * @param secondCard: Card 2 of the poker hand
     * @return Total value of hand
     */
    private int getPokerHandValue(Card firstCard, Card secondCard) {
        String handsCategory = this.getHandsCategory();
        int pokerHandValue;
        int highCardValue = Math.max(firstCard.getValue(), secondCard.getValue());
        int lowCardValue = Math.min(firstCard.getValue(), secondCard.getValue());
        pokerHandValue = switch (handsCategory) {
            case "Pair" -> highCardValue * HIGH_CARD_MULTIPLIER + lowCardValue + PAIR_SCALE_VALUE;
            case "Flush" -> highCardValue * HIGH_CARD_MULTIPLIER + lowCardValue + FLUSH_SCALE_VALUE;
            case "High Card" -> highCardValue * HIGH_CARD_MULTIPLIER + lowCardValue;
            default -> 0;
        };
        return pokerHandValue;
    }
    /**
     * Function to override the default toString method to have our own String representation of the Card Object.
     * @return String representation of the Card Object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(System.lineSeparator());
        for (Card card : cardList) {
            stringBuffer.append("| ").append(card.getShortName());
        }
        stringBuffer.append(System.lineSeparator()).append("Total:").append(this.getValue());
        return stringBuffer.toString();
    }
}

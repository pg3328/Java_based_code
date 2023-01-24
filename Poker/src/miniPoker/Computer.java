package miniPoker;

import playingCards.Card;
import playingCards.Rank;

/**
 * This class acts as a Computer hand in the Mini poker game.
 * It has features to play a new hand, take the stance and printing the hand.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class Computer {

    private PokerHand hand = new PokerHand();
    private static final int MINIMUM_VALUE_FOR_STAND = Rank.QUEEN.getValue() * PokerHand.HIGH_CARD_MULTIPLIER
            + Rank.JACK.getValue();

    public Computer() {
    }

    /**
     * returns the value of Player's hand.
     *
     * @return hand's value using poker hand get value method.
     */
    public int getValue() {
        return this.hand.getValue();
    }

    /**
     * creates a new instance of poker hand.
     */

    public void newHand() {
        this.hand = new PokerHand();
    }

    /**
     * Prints the cards in hand.
     */
    public void printHand() {
        System.out.println("==============  House Cards  ========");
        this.hand.printHand();
    }

    /**
     * Determines the stance of the player as per the minimum hand value for stance.
     *
     * @return boolean indicating whether player is standing.
     */
    public boolean stand() {
        int handValue = this.getValue();
        if (handValue >= MINIMUM_VALUE_FOR_STAND) {
            System.out.println("Computer Stands");
        } else {
            System.out.println("Computer Folds");
        }
        return handValue >= MINIMUM_VALUE_FOR_STAND;
    }

    /**
     * Adds a card into current hand.
     *
     * @param card: poker card from the deck.
     */
    public void takeCard(Card card) {
        this.hand.addCard(card);
    }
}
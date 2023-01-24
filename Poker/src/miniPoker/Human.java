package miniPoker;

import playingCards.Card;

import java.util.Scanner;

/**
 * This class acts as a human hand in the Mini poker game.
 * It has features to play a new hand, take the stance and printing the hand.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */


public class Human {

    private PokerHand hand = new PokerHand();
    private final Scanner inputScanner;

    public Human(Scanner scanner) {
        this.inputScanner = scanner;
    }

    /**
     * Compares the hand value of human and computer
     *
     * @param player: Opponent.
     * @return the difference between the hand values of the players.
     */
    public int compareTo(Computer player) {
        return this.getValue() - player.getValue();
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
        System.out.println("==============  Your Cards  ========");
        this.hand.printHand();
    }

    /**
     * Determines the stance of the player as per the user input.
     *
     * @return boolean indicating whether player is standing.
     */
    public boolean stand() {
        System.out.print("Do you want to stand (y/n)?");
        String standInput = this.inputScanner.next();
        return standInput.equals("y");
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

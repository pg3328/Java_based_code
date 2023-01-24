package playingCards;

import java.util.Random;

/**
 * This class that Creates a Deck of 52 cards needed to Play poker.
 * It has features to shuffle the cards and deal cards from the deck at request.
 *
 * @author RIT CS
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class Deck {

    private final Card[] cards = new Card[52];
    private int dealIndex = 0;
    private static final int SHUFFLE_COUNT = 75;
    /**
     * Initialize the Deck class
     * Since each Deck has 52 cards and values are fixed, we will populate 52 Cards with all possible values.
     *
     */

    public Deck() {
        int cardsIndex = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards[cardsIndex] = new Card(rank, suit);
                cardsIndex++;
            }
        }

    }

    /**
     * Deals the card at 0 Index to player on request.
     *
     * @return a Card picked up at the position deal Index.
     */
    public Card dealCard() {
        return this.cards[this.dealIndex++];
    }

    /**
     * Shuffles the Deck to make sure whenever a card picked from Deck, it's random.
     * The DeckIndex which is used to deal the card is reset to 0 whenever the Desk is shuffled.
     */
    public void shuffle() {
        System.out.println("== Shuffling");
        Random rand = new Random();
        for (int i = 0; i <= SHUFFLE_COUNT; i++) {
            int random_1 = rand.nextInt(0, 51);
            int random_2 = rand.nextInt(0, 51);
            Card temp = cards[random_1];
            cards[random_1] = cards[random_2];
            cards[random_2] = temp;
        }
        this.dealIndex = 0;
    }
}

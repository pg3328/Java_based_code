package playingCards;

/**
 * A Class to mimic Poker card.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Guntla
 */
public class Card {
    /**
     * the Card's rank. One of the values from PlayingCards.Rank enum, e.g - Ace.
     */
    private final Rank rank;
    /**
     * the Card's suit.One of the values from PlayingCards.Suit enum, e.g - Diamond.
     */
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Function to get the Rank of the Card.
     * @return the Card's rank.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Function to get the Suit of the Card.
     * @return The Card's suit.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Function to get a shorthand Representation of the Card.
     * Combines the Shortnames of Rank and Suit of the Card.
     * @return Concatenated String of shortnames of Rank and Suit of the Card
     */
    public String getShortName() {
        return String.format("%3s", this.rank.getShortName() + this.suit.getShortName());
    }

    /**
     * Function to get the rank Value of the Card.
     * @return rank Value of the card.
     */
    public int getValue() {
        return this.rank.getValue();
    }

    /**
     * Function to override the default toString method to have our own String representation of the Card Object.
     * @return String representation of the Card Object.
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }
}

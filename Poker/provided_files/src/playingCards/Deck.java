package playingCards;
import java.util.Random;

public class Deck {
    Card[] cards = new Card[52];
    static int counter=-1;

    public Deck() {
        // TODO ENUMERATE USING ENUM;
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();
        int k = 0;
        for (int i = 0; i <ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards[k] = new Card(ranks[i], suits[j]);
                k++;
            }
        }
    }

    public Card dealCard() {
        counter+=1;
        return cards[counter];
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i <= 70; i++) {
            int random = rand.nextInt(0, 52);
            Card temp = cards[random];
            cards[random] = cards[0];
            cards[0] = temp;
        }

    }
}

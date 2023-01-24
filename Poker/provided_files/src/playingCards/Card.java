package playingCards;

public class Card {
    private Rank rank;
    private Suit suit;
    public Card(Rank rank,Suit suit){
        this.rank=rank;
        this.suit=suit;
    }
    public Rank getRank(){
        return this.rank;
    }
    public String getShortName(){
        return ' '+rank.getShortName()+suit.getShortName();
    }
    public Suit getSuit(){
        return this.suit;
    }
    public int getValue(){
        return rank.getValue() ;
    }
    @Override
    public String toString(){
        return rank+" of "+suit;
    }
}

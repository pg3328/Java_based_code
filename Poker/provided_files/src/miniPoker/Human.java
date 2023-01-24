package miniPoker;
import playingCards.Card;

import java.util.Locale;
import java.util.Scanner;

public class Human {
    public Scanner input;
    PokerHand hand=new PokerHand();
    public Human(Scanner in){
        this.input=in;
    }
    public int compareTo(Computer player){
        if(this.getValue()==player.getValue()) return 0;
        else if (this.getValue()>player.getValue()) return 1;
        else return -1;
    }
    public int getValue(){
        return hand.getValue();
    }
    public void newHand(){
        hand=new PokerHand();
    }
    public void printHand(){
        hand.printHand();
    }
    public boolean stand(){
        System.out.print("Do you want to stand (y/n)?");
        String k=this.input.next();
        return (k.equals("y"));
    }
    public void takeCard(Card card){
        hand.addCard(card);
    }

}

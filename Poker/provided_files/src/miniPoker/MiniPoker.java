package miniPoker;

import playingCards.Deck;

import java.util.Scanner;

public class MiniPoker {
    static int  counter=0;
    //TODO
    public final static int Max_Cards = 2;
    public static int count = 0;

    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner sc;
        do {
            count=count+1;
            deck.shuffle();
            Scanner scanner = new Scanner(System.in);
            Human human = new Human(scanner);
            human.takeCard(deck.dealCard());
            human.takeCard(deck.dealCard());
            Computer computer = new Computer();
            computer.takeCard(deck.dealCard());
            computer.takeCard(deck.dealCard());
            System.out.println("============== Your Cards ========");
            human.printHand();
            System.out.println("Total :" + human.getValue());
            boolean stance = human.stand();
            boolean comstance = computer.stand();
            if (counter%2==0){
                System.out.println("House Cards");
                computer.printHand();
                System.out.println("Total :" + computer.getValue());
                if (stance && comstance) {
                    int a = human.compareTo(computer);
                    if (a == 0) System.out.println("---- It's a tie----");
                    else if (a == 1) System.out.println("----- Human Won ----");
                    else System.out.println("**** House Won ****");
                } else if (stance && comstance == false) {
                    System.out.println("---- Human Won----");
                } else {
                    System.out.println("---- House Won ----");
                }
                sc = new Scanner(System.in);
            }
            else{
                if (comstance==false){
                    System.out.println("Computer Folds");
                }
                else{
                System.out.println("House Cards");
                computer.printHand();
                System.out.println("Total :" + computer.getValue());
                if (stance && comstance) {
                    int a = human.compareTo(computer);
                    if (a == 0) System.out.println("---- It's a tie----");
                    else if (a == 1) System.out.println("----- Human Won ----");
                    else System.out.println("**** House Won ****");
                } else if (stance && comstance == false) {
                    System.out.println("---- Human Won----");
                } else {
                    System.out.println("---- House Won ----");
                }}
                sc = new Scanner(System.in);
            }System.out.println("Do you wish to play another hand (y/n):");
            } while (sc.next().equals("y"));
    }
}
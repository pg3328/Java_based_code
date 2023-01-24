package miniPoker;

import playingCards.Deck;

import java.util.Scanner;

/**
 * This class acts as an orchestrating class to simulate the Mini Poker game.
 * It has features to start the game, distribute cards,print stats at the end of the game.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */


public class MiniPoker {
    public static final int MAX_CARDS = 2;
    private static final Deck deck = new Deck();
    private static final String GAME_RESULTS_STRING = "========== Results ==========%n Games: %d%n Wins: %d%n Ties: %d%n";
    private static final String WINNER_STRING = "---- %s Won ----%n";
    private int totalGamesPlayed = 0;
    private int gamesWonByHuman = 0;
    private int gamesResultedInTie = 0;

    /**
     * gets the stance of both players
     * @param human: player involved
     * @param computer: house /computer involved.
     * @return String representing the stance of the players.
     */
    private String getPlayersStandChoices(Human human, Computer computer) {
        if (this.totalGamesPlayed % 2 == 0) {
            return (!computer.stand()) ? "Only Human Stands" : (!human.stand()) ? "Only Computer Stands" : "Both Stands";
        } else {

            return (!human.stand()) ? "Only Computer Stands" : (!computer.stand()) ? "Only Human Stands" : "Both Stands";
        }
    }

    /**
     * Determines the winner of the game based on the stance of the player.
     * @param human: Player of the game.
     * @param computer: Player of the game (Opponent)
     * @return String value of the winner.
     */
    private String getWinner(Human human, Computer computer) {

        String playerChoices = this.getPlayersStandChoices(human, computer);
        String winner;
        switch (playerChoices) {
            case "Only Computer stands" -> winner = "House";
            case "Only Human Stands" -> winner = "Human";
            default -> {
                int humanToCompDifference = human.compareTo(computer);
                winner = (humanToCompDifference == 0) ? "Tie" : (humanToCompDifference > 0) ? "Human" : "House";
            }
        }
        return winner;
    }

    /**
     * Prints the stats of the games.
     */
    private void printGameResults() {
        System.out.printf(GAME_RESULTS_STRING, this.totalGamesPlayed, this.gamesWonByHuman, this.gamesResultedInTie);
    }

    /**
     * Updates the games result
     * @param handResult: represent the result of hand.
     */
    private void updateGameResult(String handResult) {
        if (handResult.equals("Tie")) {
            this.gamesResultedInTie++;
        } else if (handResult.equals("Human")) {
            this.gamesWonByHuman++;
        }
    }

    /**
     * Distributes the card to the player
     * @param human: Player of the game.
     */
    private void distributeCards(Human human) {
        System.out.println("== Dealing Cards");
        for (int i = 0; i < MAX_CARDS; i++) {
            human.takeCard(deck.dealCard());
        }
        human.printHand();
    }
    /**
     * Distributes the card to the player. Overloaded function to support Computer Player
     * @param computer: COmputer player of the game.
     */
    private void distributeCards(Computer computer) {
        for (int i = 0; i < MAX_CARDS; i++) {
            computer.takeCard(deck.dealCard());
        }
    }
    /**
     * Prints String to Indicate user that New hand has started.
     */
    private static void printNewHandConfirmation() {
        System.out.println("##########################################");
        System.out.println("##########       NEW HAND      ###########");
        System.out.println("##########################################" + System.lineSeparator());
    }

    /**
     * The main method:
     * 1. Starts mini poker game and simulates the gameplay.
     * 2. Creates Human player and Computer player objects.
     * 3. Distributes the card.
     * 4. Checks if any players wants to stand. (Rotates this between human and computer every game).
     * 4. Displays each Player's hand and the result of the game
     * 5. Once human palyer decides to stop the game, Game terminates and displays the Game stats.
     *
     * @param args Not utilizing this attribute.
     */

    public static void main(String[] args) {
        MiniPoker mini = new MiniPoker();
        Scanner inputScanner = new Scanner(System.in);
        Computer computer = new Computer();
        Human human = new Human(inputScanner);
        String userInputStr;
        String winner;
        do {
            printNewHandConfirmation();
            mini.totalGamesPlayed++;
            human.newHand();
            computer.newHand();
            deck.shuffle();
            mini.distributeCards(human);
            mini.distributeCards(computer);
            winner = mini.getWinner(human, computer);
            mini.updateGameResult(winner);
            computer.printHand();
            System.out.printf(WINNER_STRING, winner);
            System.out.print("Do you wish to play another hand (y/n)? ");
            userInputStr = inputScanner.next();
        } while (userInputStr.equals("y"));
        mini.printGameResults();
    }
}
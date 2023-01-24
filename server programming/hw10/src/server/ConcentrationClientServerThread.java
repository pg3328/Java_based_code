package server;

import common.ConcentrationException;
import common.ConcentrationProtocol;
import game.ConcentrationBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client For Concentration board game. Talks to Server and based on the protocol, updates the game status.
 * Does not any information about the game. Uses Concentration Protocol to communicate with the Server.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class ConcentrationClientServerThread extends Thread {
    /**
     * Socket information of the client received from the server.
     */
    private final Socket socket;

    /**
     * Dimensions of the board from the server's CLI argument.
     */
    private final int DIM;

    /**
     * Creates a new Thread to handle a client and play Concentration Game.
     * Runs Independently of the other games.
     * @param socket Socket information of the client received from the server.
     * @param dimensions Dimensions of the board from the server's CLI argument.
     */
    public ConcentrationClientServerThread(Socket socket, int dimensions) {
        this.socket = socket;
        this.DIM = dimensions;
    }

    /**
     * run method for the Thread. Starts listening to the Client.
     * Ends when the game is over or the client disconnects.
     */
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String userInput;
            try {

                ConcentrationBoard concentrationBoard = new ConcentrationBoard(DIM);
                out.println(String.format(ConcentrationProtocol.BOARD_DIM_MSG, DIM));

                while ((userInput = in.readLine()) != null) {
                    String[] input = userInput.split(" ");
                    if (input[0].equals(ConcentrationProtocol.REVEAL)) {
                        int row = Integer.parseInt(input[1]);
                        int col = Integer.parseInt(input[2]);
                        ConcentrationBoard.CardMatch cardMatch = concentrationBoard.reveal(row, col);
                        out.println(String.format(ConcentrationProtocol.CARD_MSG, row, col, concentrationBoard.getCard(row, col).getLetter()));
                        if (cardMatch.isReady()) {
                            concentrationBoard.updateRevealStatus(cardMatch);
                            String matchMsg = cardMatch.isMatch() ? ConcentrationProtocol.MATCH_MSG : ConcentrationProtocol.MISMATCH_MSG;
                            out.println(String.format(matchMsg, cardMatch.getCard1().getRow(), cardMatch.getCard1().getCol(), cardMatch.getCard2().getRow(), cardMatch.getCard2().getCol()));

                            if (concentrationBoard.gameOver()) {
                                out.println(ConcentrationProtocol.GAME_OVER_MSG);
                                break;
                            }
                        }
                    }
                }

            } catch (ConcentrationException e) {
                out.println(String.format(ConcentrationProtocol.ERROR_MSG, e.getMessage()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

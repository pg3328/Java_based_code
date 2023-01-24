package client;

import common.ConcentrationException;
import common.ConcentrationProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

/**
 * Client For Concentration board game. Talks to Server and based on the protocol, updates the game status.
 * Does not any information about the game. Uses Concentration Protocol to communicate with the Server.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class ConcentrationClient {

    /**
     * Concentration Game board for client's reference.
     */
    private ConcentrationClientBoard clientBoard;

    /**
     * Update Client board based on the reveal status received from the server.
     *
     * @param revealStatus Reveal Status String received from the server.
     */
    public void updateRevealStatus(String revealStatus) {

        String[] revealStatusList = revealStatus.split(" ");
        if (revealStatusList[0].equals("MISMATCH")) {
            clientBoard.hideOpenedCards(Arrays.copyOfRange(revealStatusList, 1, 5));
        } else {
            clientBoard.updateMatchCount();
        }
        System.out.println(clientBoard);
    }

    /**
     * Modify the grid to the store revealed card.
     *
     * @param message String message in the format - CARD row column cardValue
     */
    public void updateConcentrationBoardCell(String message) throws ConcentrationException {

        String[] input = message.split(" ");
        if (input[0].equals("ERROR")) throw new ConcentrationException(message);
        int rowNum = 0;
        int colNum = 0;
        try {
            rowNum = Integer.parseInt(input[1]);
            colNum = Integer.parseInt(input[2]);
        } catch (NumberFormatException NFE) {
            System.out.println("Please provide input with integers only");
        }
        char letter = input[3].charAt(0);
        clientBoard.modifyGrid(rowNum, colNum, letter);
        System.out.println(clientBoard);
    }

    /**
     * Start concentration Game with the Server.
     *
     * @param hostName   hostName of the server to play the concentration game with.
     * @param portNumber portName of the server to play the concentration game wth.
     */
    public void startConcentration(String hostName, int portNumber) {

        try (Socket client = new Socket(hostName, portNumber);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            int counter = 0;
            String userInput;
            String serverInput;

            while ((serverInput = in.readLine()) != null) {

                if (clientBoard == null) {
                    System.out.println(serverInput);
                    clientBoard = new ConcentrationClientBoard(Integer.parseInt(serverInput.split(" ")[1]));
                } else {
                    updateConcentrationBoardCell(serverInput);
                    counter += 1;

                    if (counter % 2 == 0) {
                        updateRevealStatus(in.readLine());

                        if (clientBoard.isGameOver()) {
                            in.readLine();
                            System.out.println("You won!");
                            continue;
                        }
                    }
                }
                userInput = stdIn.readLine();
                String[] userInputList = userInput.split(" ");
                int row = Integer.parseInt(userInputList[0]);
                int col = Integer.parseInt(userInputList[1]);
                while (!clientBoard.validateEnteredValues(row, col)) {
                    System.out.println("Please enter valid dimensions");
                    userInput = stdIn.readLine();
                    userInputList = userInput.split(" ");
                    row = Integer.parseInt(userInputList[0]);
                    col = Integer.parseInt(userInputList[1]);
                }
                out.println(String.format(ConcentrationProtocol.REVEAL_MSG, row, col));
            }
        } catch (IOException | ConcentrationException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Starting point for the Client's version game.
     *
     * @param args CLI argument received from the user.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: Java ConcentrationClient <server_details> <port_number>");
            System.exit(1);
        }
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        ConcentrationClient concentrationClient = new ConcentrationClient();
        concentrationClient.startConcentration(hostname, port);
    }
}


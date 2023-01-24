package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server For Concentration board game. Talks to multiple clients at the same.
 * Uses ConcentrationClientServerThread to handle each client's game request.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class ConcentrationServer {

    /**
     *
     * @param args CLI Arguments received from the user. Required format is port_number board_dimension
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: Java Concentration Server <PortNumber> <Board Dimensions>");
            System.exit(-1);
        }
        int portNumber = Integer.parseInt(args[0]);
        int boardDimensions = Integer.parseInt(args[1]);
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new ConcentrationClientServerThread(socket, boardDimensions);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

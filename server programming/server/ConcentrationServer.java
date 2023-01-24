package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ConcentrationServer {

    public static void main(String[] args){
        if (args.length != 1){
            System.err.println("Usage: ConcentrationServer <port_number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try(ServerSocket serverSocket = new ServerSocket(portNumber)){
            while (listening){
                new ConcentrationServerThread(serverSocket.accept()).start();
            }
        }

        catch (IOException e){
            System.err.println("Could not listen to server");
            System.exit(1);
        }

    }

}

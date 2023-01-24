package server;

import java.net.Socket;

public class ConcentrationServerThread extends Thread{

    private Socket socket;
    @Override
    public void run() {
        System.out.println("connected");
    }

    ConcentrationServerThread(Socket socket){
        this.socket = socket;
    }


}

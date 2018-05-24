package it.polimi.se2018.client.network;

import it.polimi.se2018.network.messages.requests.Message;
import it.polimi.se2018.network.messages.responses.Response;
import it.polimi.se2018.client.view.ClientView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientConnection implements ClientConnection, Runnable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final ClientView clientView;
    private boolean isOpen;

    public SocketClientConnection(Socket socket, ClientView clientView, ObjectInputStream in, ObjectOutputStream out){
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.clientView = clientView;
        isOpen = true;
    }

    private void closeConnection(){
        try{
            in.close();
            out.close();
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(Message message){
        try{
            out.writeObject(message);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop(){
        isOpen = false;
    }

    @Override
    public void run(){
        while(isOpen){
            try{
                Response response = (Response) in.readObject();
                if (response != null) clientView.handleNetworkInput(response);
            }catch(ClassNotFoundException | IOException e){
                e.printStackTrace();
            }
        }
        closeConnection();
    }
}

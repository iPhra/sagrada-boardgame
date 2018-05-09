package it.polimi.se2018.View;

import it.polimi.se2018.Client.ModelView;
import it.polimi.se2018.Network.Connections.ClientConnection;
import it.polimi.se2018.Model.Player;
import it.polimi.se2018.Network.Messages.Requests.DraftMessage;
import it.polimi.se2018.Network.Messages.Requests.Message;
import it.polimi.se2018.Network.Messages.Requests.PassMessage;
import it.polimi.se2018.Network.Messages.Responses.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CLIClientView implements ResponseHandler {
    private final Player player;
    private final ClientConnection clientConnection;
    private ModelView board;
    private Scanner scanner = new Scanner(System.in);
    private final OutputStream output;

    public CLIClientView(Player player, ClientConnection clientConnection, ModelView board, OutputStream output) {
        this.player = player;
        this.clientConnection = clientConnection;
        this.board = board;
        this.output = output;
    }

    //receives input from the network, called by class clientConnection
    public void handleNetworkInput(Response response) {
        response.handle(this);
    }

    //called when i receive a TextResponse
    public void handleUserInput() {
    }

    //updates the board
    @Override
    public void handleResponse(ModelViewResponse modelViewResponse) {
    }

    //prints the text message
    @Override
    public void handleResponse(TextResponse textResponse) {
    }

    @Override
    public void handleResponse(TurnStartResponse turnStartResponse) {

    }

    public void chooseAction () {
        //Choose the action to do DraftDie, UseToolcard, PlaceDie, PassTurn
        int choice = -1;
        while (choice < 1 || choice > 4){
            System.out.print("It's your turn, choose your action");
            while (choice < 1 || choice > 4) {
                for (int i = 0; i < 3; i++) {
                    if (i == 0 && !player.hasDraftedDie()) {
                        System.out.print("1: Draft a die");
                    }
                    if (i == 1 && !player.hasUsedCard()) {
                        System.out.print("2: Use a toolcard");
                    }
                    if (i == 2 && player.hasDieInHand()) {
                        System.out.print("3: Place the drafted die");
                    }
                    System.out.print("4: Pass");
                }
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                draftDie();
            }
            if (choice == 2) {
                useToolcard();
            }
            if (choice == 3) {
                placeDie();
            }
            if (choice == 4) {
                passTurn();
            }
        }
    }

    public void passTurn () {
        clientConnection.sendMessage(new PassMessage(player));
    }

    public void draftDie () {
        int choice = -1;
        System.out.print("Dice on Draftpool are:");
        while (choice < 1 || choice >= board.getDraftPool().size()) {
            for (int i = 0; i < board.getDraftPool().size(); i++) {
                System.out.print(i + ": color: " + board.getDraftPool().get(i).getColor() + ", value: " + board.getDraftPool().get(i).getValue());
            }
            choice = scanner.nextInt();
        }
        clientConnection.sendMessage(new DraftMessage(player, choice));
    }

    public void useToolcard (){}

    public void placeDie (){}
}

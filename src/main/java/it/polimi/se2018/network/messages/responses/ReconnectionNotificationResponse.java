package it.polimi.se2018.network.messages.responses;

import it.polimi.se2018.network.messages.responses.Response;
import it.polimi.se2018.network.messages.responses.ResponseHandler;

public class ReconnectionNotificationResponse extends Response {
    private final String playerName;

    public ReconnectionNotificationResponse(int playerID, String playerName) {
        super(playerID);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void handleClass(ResponseHandler responseHandler) {
        responseHandler.handleResponse(this);
    }
}

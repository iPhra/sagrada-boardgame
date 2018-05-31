package it.polimi.se2018.network.messages.responses;

import it.polimi.se2018.network.messages.responses.Response;
import it.polimi.se2018.network.messages.responses.ResponseHandler;

/**
 * This is the class containing a response from the Server containing a notification that a player has disconnected
 * @author Francesco Lorenzo
 */
public class DisconnectionResponse extends Response {
    private final String message;
    private final String playerName;

    public DisconnectionResponse(int playerID, String message, String playerName) {
        super(playerID);
        this.message = message;
        this.playerName = playerName;
    }

    public String getMessage() {
        return message;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void handleClass(ResponseHandler responseHandler) {
        responseHandler.handleResponse(this);
    }
}

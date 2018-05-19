package it.polimi.se2018.model.toolcards;

import it.polimi.se2018.controller.ToolCardHandler;
import it.polimi.se2018.network.messages.responses.Response;
import it.polimi.se2018.utils.exceptions.ToolCardException;


import it.polimi.se2018.network.messages.requests.ToolCardMessage;
import it.polimi.se2018.client.view.cli.ToolCardPlayerInputHandler;

public class TapWheel extends ToolCard {

    public TapWheel() {
        super("Tap Wheel", "Move up to two dice of the same color that match the color of a die on the Round Track");
    }

    @Override
    public Response handle(ToolCardHandler handler, ToolCardMessage message) throws ToolCardException{
        return handler.useCard(this, message);
    }

    @Override
    public ToolCardMessage handleView(ToolCardPlayerInputHandler handler, int toolcardnumber) {
        return handler.getPlayerRequests(this, toolcardnumber);
    }
}


package it.polimi.se2018.client.view.gui.button;

import it.polimi.se2018.client.view.gui.button.buttoncheckusability.ButtonCheckUsabilityHandler;
import it.polimi.se2018.mvc.model.toolcards.ToolCard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonToolCard extends ButtonGame {
    private final int playerID;
    private Boolean usable;
    private final int toolCardNumber;
    private ToolCard toolCard;

    public int getToolCardNumber() {
        return toolCardNumber;
    }

    public ButtonToolCard(int playerID, int toolCardNumber, ToolCard toolCard) {
        this.playerID = playerID;
        this.toolCardNumber = toolCardNumber;
        this.toolCard = toolCard;
        setImage(toolCard.getImagePath());
        disarm();
    }

    @Override
    public void checkCondition(ButtonCheckUsabilityHandler handler){
        usable = handler.checkUsability(this);
        if(usable) arm();
        else disarm();
    }

    private void setImage(String imageUrl){
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitHeight(211);
        imageView.setFitWidth(151);
        setGraphic(imageView);
    }
}
package it.polimi.se2018.model.toolcards;

import it.polimi.se2018.controller.ToolCardHandler;
import it.polimi.se2018.model.Board;
import it.polimi.se2018.network.messages.requests.ToolCardMessage;
import it.polimi.se2018.utils.exceptions.ToolCardException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class TestFluxRemover {
    public String title = "Title";
    public String imagePath = "Image path";
    public FluxRemover fluxRemover;
    ToolCardMessage toolCardMessage;

    @Before
    public void init() {
        fluxRemover = new FluxRemover(imagePath, title,false);
    }

    @Test
    public void testHandle() throws ToolCardException {
        fluxRemover.handle(new ToolCardHandler() {
            @Override
            public void useCard(CopperFoilBurnisher toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(CorkBackedStraightedge toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(EglomiseBrush toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(FluxBrush toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(FluxRemover toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
            }

            @Override
            public void useCard(GlazingHammer toolCard, ToolCardMessage toolCardMessage) {
                fail();
            }

            @Override
            public void useCard(GrindingStone toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(GrozingPliers toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(Lathekin toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(LensCutter toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(RunningPliers toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }

            @Override
            public void useCard(TapWheel toolCard, ToolCardMessage toolCardMessage) throws ToolCardException {
                fail();
            }
        }, toolCardMessage);
    }
}
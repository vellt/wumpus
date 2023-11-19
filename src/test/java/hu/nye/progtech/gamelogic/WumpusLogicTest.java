package hu.nye.progtech.gamelogic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WumpusLogicTest {

    private WumpusLogic wumpusLogic;

    @BeforeEach
    public void setUp(){

    }

    @Test
    void takeTheGold_ShouldSetHeroHasGoldToTrue() {
        // Given
        wumpusLogic= new WumpusLogic(LoadFrom.file);
        int row=0;
        char column='A';
        for(int i=0; i< wumpusLogic.field.size(); i++) {
            if(wumpusLogic.field.get(i).getShortCut()=='G'){
                row= wumpusLogic.field.get(i).getRow();
                column=wumpusLogic.field.get(i).getColumn();
                break;
            }
        }
        // ha ugyan azon a helyen van
        wumpusLogic.getHero().setColumn(column);
        wumpusLogic.getHero().setRow(row);

        // WHEN
        boolean result = wumpusLogic.takeTheGold();

        // THEN
        Assertions.assertEquals(true,wumpusLogic.getHero().hasGold());
    }

    @Test
    void goStraightAhead_ShouldMoveHeroEastAndUpdateStepCounter() {
        // GIVEN
        WumpusLogic wumpusLogic = new WumpusLogic(LoadFrom.file);
        int initialColumn = wumpusLogic.getHero().getColumn();
        int initialStepCounter = wumpusLogic.getStepCounter();

        // WHEN
        String message = wumpusLogic.goStraightAhead();

        // THEN
        assertEquals("Csak így tovább!", message);
        assertEquals(initialColumn + 1, wumpusLogic.getHero().getColumn());
        assertEquals(initialStepCounter + 1, wumpusLogic.getStepCounter());
    }

}
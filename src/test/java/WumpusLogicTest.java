import hu.nye.progtech.gamelogic.LoadFrom;
import hu.nye.progtech.gamelogic.WumpusLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WumpusLogicTest {
    @Test
    void takeTheGold_ShouldSetHeroHasGoldToTrue() {
        // Arrange
        WumpusLogic wumpusLogic = new WumpusLogic(LoadFrom.file);

        // Act
        boolean result = wumpusLogic.takeTheGold();

        // Assert
        assertTrue(result);
        assertTrue(wumpusLogic.getHero().hasGold());
    }

    @Test
    void goStraightAhead_ShouldMoveHeroEastAndUpdateStepCounter() {
        // Arrange
        WumpusLogic wumpusLogic = new WumpusLogic(LoadFrom.file);
        int initialColumn = wumpusLogic.getHero().getColumn();
        int initialStepCounter = wumpusLogic.getStepCounter();

        // Act
        String message = wumpusLogic.goStraightAhead();

        // Assert
        assertEquals("Csak így tovább!", message);
        assertEquals(initialColumn + 1, wumpusLogic.getHero().getColumn());
        assertEquals(initialStepCounter + 1, wumpusLogic.getStepCounter());
    }

}

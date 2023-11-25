package hu.nye.progtech;

import hu.nye.progtech.views.App;
import hu.nye.progtech.views.GameOver;
import hu.nye.progtech.views.GiveUp;
import hu.nye.progtech.views.GiveYourName;
import hu.nye.progtech.views.LoadGame;
import hu.nye.progtech.views.Move;
import hu.nye.progtech.views.SaveGame;
import hu.nye.progtech.views.Shoot;
import hu.nye.progtech.views.StartGame;
import hu.nye.progtech.views.StartNewGame;
import hu.nye.progtech.views.TakeTheGold;
import hu.nye.progtech.views.TurnLeft;
import hu.nye.progtech.views.TurnRight;
import hu.nye.progtech.views.Win;
import hu.nye.progtech.views.Wumpus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void main(String[] args) {
        App.show(logger, (appMenu) -> {
            switch (appMenu) {
                case 1:
                    StartGame.show(startGameMenu -> {
                        switch (startGameMenu) {
                            case 1:
                                StartNewGame.show(startNewGameMenu -> {
                                    switch (startNewGameMenu) {
                                        case 1:
                                            GiveYourName.show(giveYourNameMenu -> {
                                                switch (giveYourNameMenu) {
                                                    case 1:
                                                        // wumpus
                                                        Wumpus.loadDataFromFile(GiveYourName.name);
                                                        Main.wumpus();
                                                        break;
                                                    case 2:
                                                        GiveYourName.repeat();
                                                        break;
                                                    default:
                                                        GiveYourName.close();
                                                }
                                            });
                                            break;
                                        default:
                                            StartNewGame.close();
                                            break;
                                    }
                                });
                                break;
                            case 2:
                                LoadGame.show(loadGameViewMenu -> {
                                    LoadGame.close();
                                    Wumpus.loadDataFromDb("vlmi");
                                    Main.wumpus();
                                });
                                break;
                            default:
                                StartGame.close();
                                break;
                        }
                    });
                    break;
                default:
                    App.close();
                    break;
            }
        });
    }

    private static void wumpus() {
        LoadGame.close();  // nincs implementálva még
        Wumpus.show(wumpusMenu -> {
            switch (wumpusMenu) {
                case 1:
                    SaveGame.show(saveGameMenu -> SaveGame.close());
                    break;
                case 2:
                    GiveUp.show(giveUpMenu -> {
                        switch (giveUpMenu) {
                            case 1:  // visszadob az app-ig
                                GiveUp.close();
                                Wumpus.close();
                                GiveYourName.close();
                                StartNewGame.close();
                                StartGame.close();
                                break;
                            default:
                                GiveUp.close();
                        }
                    });
                    break;
                case 3:
                    Move.show(Wumpus.gameLogic, moveMenu -> Move.close());
                    break;
                case 4:
                    Shoot.show(Wumpus.gameLogic, shootMenu -> Shoot.close());
                    break;
                case 5:
                    TurnLeft.show(Wumpus.gameLogic, turnLeftMenu -> TurnLeft.close());
                    break;
                case 6:
                    TurnRight.show(Wumpus.gameLogic, turnRightMenu -> TurnRight.close());
                    break;
                case 7:
                    TakeTheGold.show(Wumpus.gameLogic, takeTheGold -> TakeTheGold.close());
                    break;
                default:
                    break;
            }
            if (Wumpus.isWin()) {
                Win.show(Wumpus.gameLogic, winMenu -> Win.close());
                Wumpus.close();
                GiveYourName.close();
                StartNewGame.close();
                StartGame.close();
            }
            if (Wumpus.isGameOver()) {
                GameOver.show(gameOverMenu -> GameOver.close());
                Wumpus.close();
                GiveYourName.close();
                StartNewGame.close();
                StartGame.close();
            }
        });
    }
}
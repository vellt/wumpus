package hu.nye.progtech;

import hu.nye.progtech.views.*;


public class Main {
    public static void main(String[] args) {
        System.out.println('B'-65);
        App.show((appMenu) -> {
            switch (appMenu) {
                case 1:
                    StartGame.show(startGameMenu -> {
                        switch (startGameMenu) {
                            case 1:
                                StartNewGame.show(startNewGameMenu -> {
                                    switch (startNewGameMenu) {
                                        case 1:
                                            GiveYourName.show(giveYourNameMenu -> {
                                                switch (giveYourNameMenu){
                                                    case 1:
                                                        // wumpus
                                                        Wumpus.show(GiveYourName.name, wumpusMenu->{
                                                            switch (wumpusMenu){
                                                                case 1: SaveGame.show(saveGameMenu -> {
                                                                    SaveGame.close();
                                                                }); break; // itt az van h több almenü, kiléosz vagy nem..
                                                                case 2: GiveUp.show(giveUpMenu->{
                                                                    switch (giveUpMenu){
                                                                        case 1:  // visszadob az app-ig
                                                                            GiveUp.close();
                                                                            Wumpus.close();
                                                                            GiveYourName.close();
                                                                            StartNewGame.close();
                                                                            StartGame.close();
                                                                        default:
                                                                            GiveUp.close();
                                                                    }
                                                                    }); break;
                                                                case 3:
                                                                    Move.show(Wumpus.gameLogic,moveMenu->{
                                                                        Move.close();
                                                                    });
                                                                    break;
                                                                case 4:
                                                                    Shoot.show(Wumpus.gameLogic,shootMenu->{
                                                                        Shoot.close();
                                                                    });
                                                                    break;
                                                                case 5:
                                                                    TurnLeft.show(Wumpus.gameLogic,turnLeftMenu->{
                                                                        TurnLeft.close();
                                                                    });
                                                                    break;
                                                                case 6:
                                                                    TurnRight.show(Wumpus.gameLogic,turnRightMenu->{
                                                                        TurnRight.close();
                                                                    });
                                                                    break;
                                                                case 7:
                                                                    TakeTheGold.show(Wumpus.gameLogic,takeTheGold->{
                                                                        TakeTheGold.close();
                                                                    });
                                                                    break;
                                                            }
                                                            if(Wumpus.hasWin()){
                                                                Win.show();
                                                                Win.close();
                                                                Wumpus.close();
                                                                GiveYourName.close();
                                                                StartNewGame.close();
                                                                StartGame.close();
                                                            }
                                                        });
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
                                LoadGame.show(loadGameMenu -> {
                                    LoadGame.close();  // nincs implementálva még
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
}
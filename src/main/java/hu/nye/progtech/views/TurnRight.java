package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class TurnRight {

    public static boolean viewLoop =true;

    public static void show(WumpusLogic gameLogic, MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Jobbra fordulás--------------------"+ConsoleColor.RESET);
            gameLogic.getHero().turnRight() ;
            System.out.println("A  hősöd most már " + gameLogic.getHero().getDirectionAsHU() + "i irányba néz");
            callback.Call(-1);
        }
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

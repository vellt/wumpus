package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class TurnLeft {

    public static boolean viewLoop =true;

    public static void show(WumpusLogic gameLogic, MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Balra fordulás--------------------"+ConsoleColor.RESET);
            gameLogic.getHero().turnLeft();
            System.out.println("A  hősöd iránya most már: " + gameLogic.getHero().getDirectionAsCharacter());
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

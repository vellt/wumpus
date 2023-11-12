package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class TakeTheGold {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(WumpusLogic gameLogic, MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Arany felvétele--------------------"+ConsoleColor.RESET);
            if(gameLogic.isThereAGoldWhereWeAre()){
                System.out.println("Felvetted az aranyat");
            }else{
                System.out.println("A helyen ahol állsz nincs arany");
            }
            callback.Call(viewMenu);
        }
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

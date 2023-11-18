package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class Win {

    public static boolean viewLoop =true;

    static int viewMenu =-1;

    public static void show(WumpusLogic wumpusLogic, MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Nyertél--------------------"+ConsoleColor.RESET);
            System.out.println("Gratulálok! Sikerült "+ wumpusLogic.getStepCounter() +" lépés számmal visszatérned az arannyal a kezdőpontra!");
            callback.Call(viewMenu);
        }
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class GameOver {

    public static boolean viewLoop =true;

    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Vesztettél--------------------"+ConsoleColor.RESET);
            System.out.println("Sajnos ez most nem sikerült!");
            callback.Call(viewMenu);
        }
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

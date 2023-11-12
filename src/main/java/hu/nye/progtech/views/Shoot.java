package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class Shoot {

    public static boolean viewLoop =true;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Lövés--------------------"+ConsoleColor.RESET);
            System.out.println("Nincs implementálva-->kilépés");
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

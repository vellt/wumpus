package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class SaveGame {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.GREEN +"-----------------Játék mentése--------------------"+ConsoleColor.RESET);
            System.out.println("Nincs implementálva-->kilépés");
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

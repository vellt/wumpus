package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class LoadGame {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("*******LoadGame*********");
            System.out.println("Nincs implementálva-->kilépés");
            callback.Call(1);
        }
    }

    public static boolean close(){
        return viewLoop =false;
    }


}

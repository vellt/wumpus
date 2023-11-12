package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

public class TurnLeft {

    public static boolean viewLoop =true;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Balra fordulás--------------------");
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

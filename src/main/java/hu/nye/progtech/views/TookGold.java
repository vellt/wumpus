package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class TookGold {

    public static boolean viewLoop =true;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Arany felvéve--------------------");
            System.out.println("Az arany bekerült a tarisznyádba");
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

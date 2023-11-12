package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class GiveUp {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Játék feladása (kilépés)--------------------");
            Scanner scanner= new Scanner(System.in);
            System.out.println("1. Igen, feladom!");
            System.out.println("2. Nem, folyatatom!");
            System.out.print("menü: ");
            if(scanner.hasNextInt() )
            viewMenu = scanner.nextInt();
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

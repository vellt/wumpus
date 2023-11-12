package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class StartNewGame {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Új játék indítása--------------------");
            Scanner scanner= new Scanner(System.in);
            System.out.println("1. Név megadása");
            System.out.println("2. Vissza");
            System.out.print("menü: ");
            if(scanner.hasNextInt() )
            viewMenu = scanner.nextInt();
            callback.Call(viewMenu);
        }
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

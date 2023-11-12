package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class StartGame {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Játék--------------------");
            Scanner scanner= new Scanner(System.in);
            System.out.println("1. Új játék");
            System.out.println("2. Játék betöltése");
            System.out.println("3. Vissza");
            System.out.print("menü: ");
            if(scanner.hasNextInt())
            viewMenu = scanner.nextInt();
            callback.Call(viewMenu);
        }
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

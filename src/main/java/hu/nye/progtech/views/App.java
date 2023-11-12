package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class App {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------APP--------------------");
            Scanner scanner= new Scanner(System.in);
            System.out.println("1. Játék");
            System.out.println("2. Kilépés");
            System.out.print("menü: ");
            if(scanner.hasNextInt() )
                viewMenu = scanner.nextInt();

            callback.Call(viewMenu);
        }
    }

    public static void close(){
        viewLoop =false;
    }

}

package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class StartGame {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Játék--------------------"+ConsoleColor.RESET);
            Scanner scanner= new Scanner(System.in);
            System.out.println(ConsoleColor.GREEN +"1."+ConsoleColor.RESET+" Új játék");
            System.out.println(ConsoleColor.GREEN +"2."+ConsoleColor.RESET+" Játék betöltése");
            System.out.println(ConsoleColor.GREEN +"3."+ConsoleColor.RESET+" Vissza");
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

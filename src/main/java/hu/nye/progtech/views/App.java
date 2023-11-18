package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class App {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE+"-----------------APP--------------------"+ConsoleColor.RESET);
            Scanner scanner= new Scanner(System.in);
            System.out.println(ConsoleColor.GREEN +"1."+ConsoleColor.RESET+" Játék indítása");
            System.out.println(ConsoleColor.GREEN +"2."+ConsoleColor.RESET+" Kilépés");
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

package hu.nye.progtech.views;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class GiveYourName {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static String name="";

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------APP--------------------"+ConsoleColor.RESET);
            Scanner scanner= new Scanner(System.in);
            System.out.print("felhasználónév: ");
            if(scanner.hasNext() )
            name= scanner.nextLine();

            System.out.println(ConsoleColor.GREEN +"1."+ConsoleColor.RESET+" Wumpusz indítása");
            System.out.println(ConsoleColor.GREEN +"2."+ConsoleColor.RESET+" Név módosítása");
            System.out.println(ConsoleColor.GREEN +"3."+ConsoleColor.RESET+" Vissza");
            System.out.print("menü: ");
            if(scanner.hasNextInt() )
            viewMenu = scanner.nextInt();
            callback.Call(viewMenu);
        }
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static void close(){
        viewLoop =false;
    }


}

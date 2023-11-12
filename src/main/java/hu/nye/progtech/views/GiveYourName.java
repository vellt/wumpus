package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class GiveYourName {

    public static boolean viewLoop =true;
    static int viewMenu =-1;

    public static String name="";

    public static void show(MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------APP--------------------");
            Scanner scanner= new Scanner(System.in);
            System.out.print("felhasználónév: ");
            if(scanner.hasNext() )
            name= scanner.nextLine();

            System.out.println("1. Wumpusz indítása");
            System.out.println("2. Név módosítása");
            System.out.println("3. Vissza");
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

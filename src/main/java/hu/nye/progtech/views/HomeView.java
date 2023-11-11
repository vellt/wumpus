package hu.nye.progtech.views;

import java.util.Scanner;

public class HomeView {

    static String userName;

    public static void show(Callback callback){
        System.out.println("*****WUMPUS*******");
        System.out.println("\tbelépés");
        System.out.print("felhasználónév: ");
        Scanner scanner= new Scanner(System.in);
        userName= scanner.nextLine();
        callback.Call(isUserNameValid(), userName);
    }

    static boolean isUserNameValid(){
        return  !userName.isEmpty();
    }

    public  interface Callback{
        void Call(boolean isUserNameValid, String userName);
    }

}

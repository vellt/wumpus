package hu.nye.progtech.views;

import java.util.Scanner;

public class MenuView {

    static int chosenMenuValue=-1;
    static boolean stayIn=true;
    public static boolean show(Callback callback){
        while (stayIn){
            System.out.println("******************");
            System.out.println("\tmenü");
            System.out.println("1. pályaszerkesztés");
            System.out.println("2. fájlból beolvasás");
            System.out.println("3. adatbázisból betöltés");
            System.out.println("4. adatbázisba mentés");
            System.out.println("5. játszás");
            System.out.println("6. kilépés");
            System.out.print("Válasszon egy menüpontot: ");
            Scanner scanner= new Scanner(System.in);
            chosenMenuValue= scanner.nextInt();
            stayIn= callback.Call(chosenMenuValue);
        }
        return stayIn;
    }

    public  interface Callback{
        boolean Call(int chosenMenu);
    }
}

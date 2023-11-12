package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.LoadFrom;
import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.MenuCallback;

import java.util.Scanner;

public class Wumpus {

    public static boolean viewLoop =true;
    static int viewMenu =-1;
    static boolean isWin;


    public static void show(String name,MenuCallback callback){
        WumpusLogic logic= new WumpusLogic(LoadFrom.file);
        viewLoop =true;
        while (viewLoop){
            System.out.println("-----------------Wumpus--------------------");
            // kezdő pálya betöltése
            logic.drawField();

            // hős adatai
            logic.getHero().setName(name);
            System.out.println("Hős adatai:");
            System.out.println("neve: "+logic.getHero().getName());
            System.out.println("pozíciója: "+logic.getHero().getColumn()+","+logic.getHero().getRow());
            System.out.println("iránya: "+logic.getHero().getDirectionAsHU());
            System.out.println("arany: "+logic.getHero().hasGold());
            System.out.println("nyilak száma: "+logic.getHero().getArrowCount());

            Scanner scanner= new Scanner(System.in);
            System.out.println("1. Játék mentése");
            System.out.println("2. Játék feladása (kilépés)");
            System.out.println("3. Lépés");
            System.out.println("4. Lövés");
            System.out.println("5. Balra fordulás");
            System.out.println("6. Jobbra fordulás");
            System.out.println("7. Arany felvétele");
            System.out.print("menü: ");
            if(scanner.hasNextInt() )
            viewMenu = scanner.nextInt();
            callback.Call(viewMenu);
        }
    }

    public static boolean hasWin(){
        return isWin;
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

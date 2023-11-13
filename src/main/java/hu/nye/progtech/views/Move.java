package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

public class Move {

    public static boolean viewLoop =true;

    public static void show(WumpusLogic gameLogic, MenuCallback callback){
        viewLoop =true;
        while (viewLoop){
            System.out.println(ConsoleColor.BLUE +"-----------------Lépés--------------------"+ConsoleColor.RESET);
            System.out.println("Nincs implementálva-->kilépés");
            // ha tudunk erre lépni, akkor legyen ez az új értékem,
            gameLogic.goStraightAhead();
            // ellenőrízzük, hogy ki, vaqy mi van  ott, wumpus van ott? pit van ott? vagy arany
            // ha nem tudnk arra lépni, az azért van mert fal van ott!
            callback.Call(-1);
        }
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

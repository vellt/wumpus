package hu.nye.progtech.views;

public class Win {

    public static boolean viewLoop =true;

    public static void show(){
        viewLoop =true;
        while (viewLoop){
            System.out.println("*******WUMPUS*********");
            System.out.println(" belépés");
            System.out.println("**********************");
            System.out.print("felhasználónév: ");
        }
    }

    public static void repeat(){
        viewLoop =true;
    }

    public static boolean close(){
        return viewLoop =false;
    }

}

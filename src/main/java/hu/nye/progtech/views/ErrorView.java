package hu.nye.progtech.views;

public class ErrorView {
    public  static boolean show(String message){
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("**********************");
        System.out.println(" Hiba!");
        System.out.println("**********************");
        System.out.println(message);
        return true;
    }
}

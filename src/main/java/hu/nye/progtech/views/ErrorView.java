package hu.nye.progtech.views;

public class ErrorView {
    public  static boolean show(String message){
        System.out.println("\tHiba!");
        System.out.println(message);
        return true;
    }
}

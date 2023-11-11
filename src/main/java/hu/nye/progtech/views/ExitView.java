package hu.nye.progtech.views;

import hu.nye.progtech.controllers.ExitViewController;

import java.util.Scanner;

public class ExitView {
    private static final ExitViewController controller= new ExitViewController();
    public static boolean show(){
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("**********************");
        System.out.println(" kilépés");
        System.out.println("**********************");
        System.out.println("Biztos kiszeretnél lépni? (y/n)");
        return !controller.exit();
    }
}

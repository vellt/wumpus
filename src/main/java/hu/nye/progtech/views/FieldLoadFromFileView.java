package hu.nye.progtech.views;

import hu.nye.progtech.controllers.FieldLoadFromFileController;

import java.util.Scanner;

public class FieldLoadFromFileView {

    private static final FieldLoadFromFileController controller= new FieldLoadFromFileController();
    public static boolean show(){
        System.out.println("******************");
        System.out.println("\tFájlból beolvasás");
        System.out.println("Add meg a fájl elérési útvonalát");
        controller.setFieldPath();
        return true;
    }
}

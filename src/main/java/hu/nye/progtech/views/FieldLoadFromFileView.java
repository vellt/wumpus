package hu.nye.progtech.views;

import hu.nye.progtech.controllers.FieldLoadFromFileViewController;

public class FieldLoadFromFileView {

    public static final FieldLoadFromFileViewController controller= new FieldLoadFromFileViewController();
    public static boolean show(String name){
        controller.setName(name);
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("**********************");
        System.out.println(" Fájlból beolvasás");
        System.out.println("**********************");
        System.out.println("A beolvasott pálya:");
        System.out.println("\n");
        controller.loadData();
        return true;
    }


}

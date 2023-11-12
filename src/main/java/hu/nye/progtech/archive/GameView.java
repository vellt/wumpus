package hu.nye.progtech.archive;

import hu.nye.progtech.controllers.FieldLoadFromFileViewController;

public class GameView {
    public  static  boolean show(FieldLoadFromFileViewController controller){
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("**********************");
        System.out.println(" Játék mód");
        System.out.println("**********************");
        if(controller.getFields().toArray().length!=0){
            System.out.println("A pálya állapot:");
            controller.drawTheField();
            System.out.println("Hősöd adatai");
            System.out.println("Neve: "+controller.getHero().getName());
            System.out.println("Nyilak száma: "+controller.getHero().getArrowCount());
            System.out.println("Amerre néz: "+controller.getHero().getDirection());
            System.out.println("sor: "+controller.getHero().getRow());
            System.out.println("oszlop: "+controller.getHero().getColumn());

            System.out.println("fordulj jobbra");
            /*
            System.out.println(controller.getHero().getDirection());
            System.out.println(controller.getHero().turnLeft());
            System.out.println(controller.getHero().turnLeft());
            System.out.println(controller.getHero().turnLeft());
            System.out.println(controller.getHero().turnLeft());
            System.out.println(controller.getHero().turnLeft());
            System.out.println(controller.getHero().turnRight());
            System.out.println(controller.getHero().turnRight());
            System.out.println(controller.getHero().turnRight());
            */
            controller.getHero().step(controller.getFields());

        }else{
            System.out.println("Nincs pálya betöltve");
        }

        return true;
    }
}

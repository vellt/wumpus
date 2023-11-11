package hu.nye.progtech.controllers;

import java.util.Scanner;

public class ExitViewController {
    public boolean exit(){
        Scanner scanner= new Scanner(System.in);
        return (scanner.nextLine().equalsIgnoreCase("y"));
    }
}

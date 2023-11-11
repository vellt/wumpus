package hu.nye.progtech.controllers;

import java.util.Scanner;

public class FieldLoadFromFileController {
    String filePath="";
    public void setFieldPath(){
        Scanner scanner= new Scanner(System.in);
        filePath= scanner.nextLine();
    }
}

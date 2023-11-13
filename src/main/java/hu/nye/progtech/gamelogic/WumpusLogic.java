package hu.nye.progtech.gamelogic;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class WumpusLogic {
    List<FieldObject> field = new ArrayList<>();
    Hero hero= new Hero();

    boolean gameOver=false;
    int matrixLength=0;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public WumpusLogic(LoadFrom loadFrom){
        switch (loadFrom){
            case file:
                FieldLoader loader= new FieldLoader();
                hero= loader.getHero();
                field = loader.getField();
                matrixLength=loader.getMatrixLength();
                break;
        }
    }
    public Hero getHero(){
        return this.hero;
    }

    public boolean takeTheGold(){
        FieldObject currentPlace= field.stream()
                .filter(field -> field.getRow() == hero.getRow() && field.getColumn()==hero.getColumn()).toList().get(0);
        if(currentPlace.getShortCut()=='G'){
            currentPlace.setShortCut('_');
            hero.setThereIsGold(true);
            return true;
        }else{
            return false;
        }
    }

    public  String goStraightAhead (){
        String message="Csak így tovább!";
       switch (hero.getDirection()){
            case East -> {
                FieldObject nextPlace= field.stream()
                        .filter(field -> field.getRow() == hero.getRow() && field.getColumn()==hero.getColumn()+1).toList().get(0);
               if(nextPlace.getShortCut()!='W') {
                    hero.setRow(nextPlace.getRow());
                    hero.setColumn(nextPlace.getColumn());
                    if(nextPlace.getShortCut()=='U'){
                        setGameOver(true); // a wumpus megölt
                        message="A wumpus megölt!";
                    }
                    if(nextPlace.getShortCut()=='G'){
                        message="Jé! Itt van egy arany! Vedd fel!";
                    }
                    if(nextPlace.getShortCut()=='P'){
                        if(hero.getArrowCount()==1){
                            message="Elvesztettél a mocsárban egy nyilat!";
                        }
                        hero.lostAnArrow();

                    }

                }else{
                   message="Fal van előtted!";
               }
            }
           case South -> {
               FieldObject nextPlace= field.stream()
                       .filter(field -> field.getRow() == hero.getRow()+1 && field.getColumn()==hero.getColumn()).toList().get(0);
               if(nextPlace.getShortCut()!='W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if(nextPlace.getShortCut()=='U'){
                       setGameOver(true); // a wumpus megölt
                       message="A wumpus megölt!";
                   }
                   if(nextPlace.getShortCut()=='G'){
                       message="Jé! Itt van egy arany! Vedd fel!";
                   }
                   if(nextPlace.getShortCut()=='P'){
                       if(hero.getArrowCount()==1){
                           message="Elvesztettél a mocsárban egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }

               }else{
                   message="Fal van előtted!";
               }
           }
           case North -> {
               FieldObject nextPlace= field.stream()
                       .filter(field -> field.getRow() == hero.getRow()-1 && field.getColumn()==hero.getColumn()).toList().get(0);
               if(nextPlace.getShortCut()!='W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if(nextPlace.getShortCut()=='U'){
                       setGameOver(true); // a wumpus megölt
                       message="A wumpus megölt!";
                   }
                   if(nextPlace.getShortCut()=='G'){
                       message="Jé! Itt van egy arany! Vedd fel!";
                   }
                   if(nextPlace.getShortCut()=='P'){
                       if(hero.getArrowCount()==1){
                           message="Elvesztettél a mocsárban egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }

               }else{
                   message="Fal van előtted!";
               }
           }
           default -> {
               FieldObject nextPlace= field.stream()
                       .filter(field -> field.getRow() == hero.getRow() && field.getColumn()==hero.getColumn()-1).toList().get(0);
               if(nextPlace.getShortCut()!='W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if(nextPlace.getShortCut()=='U'){
                       setGameOver(true); // a wumpus megölt
                       message="A wumpus megölt!";
                   }
                   if(nextPlace.getShortCut()=='G'){
                       message="Jé! Itt van egy arany! Vedd fel!";
                   }
                   if(nextPlace.getShortCut()=='P'){
                       if(hero.getArrowCount()==1){
                           message="Elvesztettél a mocsárban egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }

               }else{
                   message="Fal van előtted!";
               }
           }
        }
        return message;

    }


    public boolean shootWithArrow(){
        switch (hero.getDirection()){
            case East -> {
                List<FieldObject> filteredList= field.stream()
                        .filter(field -> field.getRow() == hero.getRow()).toList();
                boolean heKilledTheWumpus=false;

                for (int i=hero.getColumn()-65; i<matrixLength;i++){ // itt lesz gond az átlváltással 64->0
                    if(filteredList.get(i).getShortCut()=='U'){
                        //találta a nyil
                        heKilledTheWumpus=true;
                        removeWumpusFromTheField();
                        break;
                    }
                }
                hero.lostAnArrow();
                return heKilledTheWumpus; // ha true, akkor megöltem a wumpuszt, ha false, akkor falnak ütközött a lövedékem, vagy nem volt nyilam
            }
            case South -> {
                boolean heKilledTheWumpus=false;
                List<FieldObject> filteredList= field.stream()
                        .filter(field -> field.getColumn() == hero.getColumn()).toList(); //azért mert vertikálisan haladok
                // kinyertem az oszlop azon sorait amiben a hős van
                for (int i=hero.getRow(); i<matrixLength;i++){
                    if(filteredList.get(i).getShortCut()=='U'){
                        //találta a nyil
                        heKilledTheWumpus=true;
                        removeWumpusFromTheField();
                        break;
                    }
                }
                hero.lostAnArrow();
                return  heKilledTheWumpus;
            }
            case West ->{
                List<FieldObject> filteredList= field.stream()
                        .filter(field -> field.getRow() == hero.getRow()).toList();
                boolean heKilledTheWumpus=false;

                for (int i=hero.getColumn()-65; i>0;i--){ // itt lesz gond az átlváltással 64->0, azért nagyobb min 0, mert a falat felesleges vizsgálni
                    if(filteredList.get(i).getShortCut()=='U'){
                        //találta a nyil
                        heKilledTheWumpus=true;
                        removeWumpusFromTheField();

                        break;
                    }
                }
                hero.lostAnArrow();
                return heKilledTheWumpus; // ha true, akkor megöltem a wumpuszt, ha false, akkor falnak ütközött a lövedékem, vagy nem volt nyilam
            }
            default -> {
                boolean heKilledTheWumpus=false;
                List<FieldObject> filteredList= field.stream()
                        .filter(field -> field.getColumn() == hero.getColumn()).toList(); //azért mert vertikálisan haladok
                for (int i=hero.getRow(); i>0;i--){
                    if(filteredList.get(i).getShortCut()=='U'){
                        //találta a nyil
                        heKilledTheWumpus=true;
                        removeWumpusFromTheField();
                        break;
                    }
                }
                hero.lostAnArrow();
                return  heKilledTheWumpus;
            }
        }
    }

    private void removeWumpusFromTheField() {
        for(int i=0; i< field.size(); i++) {
            if(field.get(i).getShortCut()=='U'){
                field.get(i).setShortCut('_');
                break;
            }
        }
    }

    private boolean conditionForColoring(FieldObject fieldElement){
        return fieldElement.getColumn()==hero.getColumn() && fieldElement.getRow()==hero.getRow();
    }

    public void drawField() {

        field.sort(Comparator
                .comparing(FieldObject::getRow)
                .thenComparing(FieldObject::getColumn));
        IntStream.range(0, matrixLength+1).forEach(column->{
            if((column==0)){
                System.out.printf("%c\t", ' ');
            }else{
                System.out.printf("%3c", (char)column+64);
            }

        });
        System.out.print("\n\n");
        field.forEach((fieldElement)->{
            if(fieldElement.getColumn()-64==matrixLength){
                if(fieldElement.getColumn()-64==0){
                    if(conditionForColoring(fieldElement)){
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n"+ConsoleColor.RESET,fieldElement.getShortCut());
                    }else{
                        System.out.printf("%3s\n",fieldElement.getShortCut());
                    }
                }else{
                    if(conditionForColoring(fieldElement)){
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n"+ConsoleColor.RESET,fieldElement.getShortCut());
                    }else{
                        System.out.printf("%3s\n",fieldElement.getShortCut());
                    }
                }

            }else{
                if(fieldElement.getColumn()=='A'){
                    if(conditionForColoring(fieldElement)){
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%d\t"+ConsoleColor.RESET, fieldElement.getRow());
                    }else{
                        System.out.printf("%d\t", fieldElement.getRow());
                    }

                }
                if(conditionForColoring(fieldElement)){
                    System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND +"%3s"+ConsoleColor.RESET,fieldElement.getShortCut());
                }else{
                    System.out.printf("%3s",fieldElement.getShortCut());
                }

            }
        });
    }
}

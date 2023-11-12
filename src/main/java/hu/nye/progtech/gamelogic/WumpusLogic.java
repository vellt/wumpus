package hu.nye.progtech.gamelogic;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class WumpusLogic {
    List<FieldObject> field = new ArrayList<>();
    Hero hero= new Hero();

    int matrixLength=0;

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

    public boolean isThereAGoldWhereWeAre(){
        Optional<FieldObject> firstFieldWithG = field.stream()
                .filter(field -> field.getShortCut() == 'G')
                .findFirst();

        if (firstFieldWithG.isPresent()) {
            FieldObject result = firstFieldWithG.get();
            return result.getColumn() == getHero().getColumn() && result.getRow() == getHero().getRow();
        } else {
            return false;
        }
    }

    public boolean shootWithArrow(){
        switch (hero.getDirection()){
            case East -> {
                List<FieldObject> filteredList= field.stream()
                        .filter(field -> field.getRow() == hero.getRow()).toList();
                boolean heKilledTheWumpus=false;
                for (int i=hero.getColumn(); i<matrixLength;i++){
                    if(filteredList.get(i).getShortCut()=='U'){
                        //találta a nyil
                        heKilledTheWumpus=true;
                        break;
                    }
                }
                return heKilledTheWumpus;
            }
            case South -> {

            }
            case West ->{

            }
            default -> {

            }
        }
        return false;
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
                        System.out.printf(ConsoleColor.GREEN + "%3s\n"+ConsoleColor.RESET,fieldElement.getShortCut());
                    }else{
                        System.out.printf("%3s\n",fieldElement.getShortCut());
                    }
                }else{
                    if(conditionForColoring(fieldElement)){
                        System.out.printf(ConsoleColor.GREEN + "%3s\n"+ConsoleColor.RESET,fieldElement.getShortCut());
                    }else{
                        System.out.printf("%3s\n",fieldElement.getShortCut());
                    }
                }

            }else{
                if(fieldElement.getColumn()=='A'){
                    if(conditionForColoring(fieldElement)){
                        System.out.printf(ConsoleColor.GREEN + "%d\t"+ConsoleColor.RESET, fieldElement.getRow());
                    }else{
                        System.out.printf("%d\t", fieldElement.getRow());
                    }

                }
                if(conditionForColoring(fieldElement)){
                    System.out.printf(ConsoleColor.GREEN +"%3s"+ConsoleColor.RESET,fieldElement.getShortCut());
                }else{
                    System.out.printf("%3s",fieldElement.getShortCut());
                }

            }
        });
    }
}

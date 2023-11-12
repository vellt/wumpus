package hu.nye.progtech.gamelogic;

import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
                    System.out.printf("%3s\n",fieldElement.getShortCut());
                }else{
                    System.out.printf("%3s\n",fieldElement.getShortCut());
                }

            }else{
                if(fieldElement.getColumn()=='A'){
                    System.out.printf("%d\t", fieldElement.getRow());
                }
                System.out.printf("%3s",fieldElement.getShortCut());
            }
        });
    }
}

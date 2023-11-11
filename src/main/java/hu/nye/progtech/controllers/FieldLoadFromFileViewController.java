package hu.nye.progtech.controllers;
import hu.nye.progtech.models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class FieldLoadFromFileViewController {

    private List<FieldObject> fields= new ArrayList<>();
    private int matrixLength=0;

    private String name="";

    public List<FieldObject> getFields() {
        return fields;
    }

    public void setFields(List<FieldObject> fields) {
        this.fields = fields;
    }

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    private Direction getCorrectDirection(char direction){
        return switch (direction) {
            case 'N' -> Direction.North;
            case 'W' -> Direction.West;
            case 'S' -> Direction.South;
            default -> Direction.East;
        };
    }

    private int specifiedFieldCounter(char shortCut){
               return (int)fields.stream()
                        .map(FieldObject::getShortCut) // Csak az első karaktert nézzük
                        .filter(c -> c == shortCut)
                        .count();
    }

    public void drawTheField(){
        fields.sort(Comparator
                .comparing(FieldObject::getRow)
                .thenComparing(FieldObject::getColumn));
        //fields.forEach(System.out::println);
        //System.out.println(matrixLength);
        IntStream.range(0, matrixLength+1).forEach(column->{
            if((column==0)){
                System.out.printf("%c\t", ' ');
            }else{
                System.out.printf("%3c", (char)column+64);
            }

        });
        System.out.print("\n\n");
        fields.forEach((fieldElement)->{
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

    public void loadData(){
        Path projectDirectory = Paths.get(System.getProperty("user.dir"));
        Path relativePath = Paths.get("src","main","java","hu","nye","progtech","data", "wumpuszinput.txt");
        Path fullPath = projectDirectory.resolve(relativePath);
        try {
            String content = Files.readString(fullPath);
            String[] splitLine= content.split("\n");
            if(splitLine.length>0){
                // A mátrix n értéke
                String[] firstLine= splitLine[0].split(" ");
                matrixLength= Integer.parseInt(firstLine[0]);
                // System.out.println(matrixLength);


                //System.out.println(hero);

                // további adat betölése
                for (int row=1; row<=matrixLength;row++){
                    for(int column=0; column<matrixLength;column++){
                          fields.add(new FieldObject(
                                  splitLine[row].charAt(column),
                                  (char)(column+65), // mert az A-->65ös indexű az ASCII-ben
                                  row
                          ));
                    }
                }
                // hős adatainak a betöltése
                hero= new Hero(
                        'H',
                        firstLine[1].charAt(0),
                        Integer.parseInt(firstLine[2]),
                        getCorrectDirection(firstLine[3].charAt(0)),
                        specifiedFieldCounter('U'),
                        getName());

                insertHeroIntoTheField(hero);
                drawTheField();



            }

            // System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertHeroIntoTheField(Hero hero) {
         int index= IntStream.range(0, fields.size())
                 .filter(i -> fields.get(i).getColumn() == hero.getColumn()
                         && fields.get(i).getRow() == hero.getRow()
                         && fields.get(i).getShortCut()!='W'
                         && fields.get(i).getShortCut()!='U'
                         && fields.get(i).getShortCut()!='P'
                 )
                 .findFirst().orElse(-1);
         if(index!=-1){
             fields.set(index, hero);
         }
    }
}

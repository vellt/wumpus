package hu.nye.progtech.gamelogic;

import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FieldLoader {

    /*
    List<FieldObject>
    int matrixLength=0;
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
     */

}

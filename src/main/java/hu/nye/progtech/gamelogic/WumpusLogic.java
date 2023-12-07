package hu.nye.progtech.gamelogic;


import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.datacontrollers.LoadFrom;
import hu.nye.progtech.datacontrollers.dbcontroller.DatabaseLoader;
import hu.nye.progtech.datacontrollers.filecontroller.FileLoader;
import hu.nye.progtech.model.FieldObject;
import hu.nye.progtech.model.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class WumpusLogic {
    public List<FieldObject> field = new ArrayList<>();
    public Hero hero = new Hero();
    boolean gameOver = false;
    boolean win = false;

    public boolean isWin() {
        return win;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public WumpusLogic(LoadFrom loadFrom, int id, DatabaseLoader databaseLoader) {
        FileLoader fileLoader = new FileLoader();
        switch (loadFrom) {
            case file:
                hero = fileLoader.getHero();
                hero.setStartColumn(hero.getColumn());
                hero.setStartRow(hero.getRow());
                // beállítjuk a kezdeti értéket, mert ez lesz a cél
                field = fileLoader.getField();
                hero.setMatrixLength(fileLoader.getMatrixLength());
                break;
            default:
                // játék betöltése adb-ből név alapján
                hero = databaseLoader.getHeroData(id);
                field = fileLoader.getField();
                break;
        }
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public Hero getHero() {
        return this.hero;
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public boolean takeTheGold() {
        FieldObject currentPlace = field.stream()
                .filter(field -> field.getRow() == hero.getRow() && field.getColumn() == hero.getColumn()).toList().get(0);
        if (currentPlace.getShortCut() == 'G') {
            currentPlace.setShortCut('_');
            hero.setThereIsGold(true);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Let's call this as the first sentence,
     * here the second one. // minden lépésnél ellenrzöm
     */
    private void winStateChecker() {
        if (hero.isWinner()) {
            // nyertem
            win = true;
        }
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public String goStraightAhead() {
       String message = "Csak így tovább!";
       switch (hero.getDirection()) {
            case East -> {
                FieldObject nextPlace = field.stream()
                        .filter(field -> field.getRow() == hero.getRow() && field.getColumn() == hero.getColumn() + 1).toList().get(0);
               if (nextPlace.getShortCut() != 'W') {
                    hero.setRow(nextPlace.getRow());
                    hero.setColumn(nextPlace.getColumn());
                    if (nextPlace.getShortCut() == 'U') {
                        setGameOver(true); // a wumpus megölt
                        message = "A wumpus megölt!";
                    }
                    if (nextPlace.getShortCut() == 'G') {
                        message = "Jé! Itt van egy arany! Vedd fel!";
                    }
                    if (nextPlace.getShortCut() == 'P') {
                        if (hero.getArrowCount() == 1) {
                            message = "Elvesztettél a veremben egy nyilat!";
                        }
                        hero.lostAnArrow();
                    }
                   int step = hero.getStep();
                   step++;
                   hero.setStep(step);

               } else {
                   message = "Fal van előtted!";
               }
            }
           case South -> {
               FieldObject nextPlace = field.stream()
                       .filter(field -> field.getRow() == hero.getRow() + 1 && field.getColumn() == hero.getColumn()).toList().get(0);
               if (nextPlace.getShortCut() != 'W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if (nextPlace.getShortCut() == 'U') {
                       setGameOver(true); // a wumpus megölt
                       message = "A wumpus megölt!";
                   }
                   if (nextPlace.getShortCut() == 'G') {
                       message = "Jé! Itt van egy arany! Vedd fel!";
                   }
                   if (nextPlace.getShortCut() == 'P') {
                       if (hero.getArrowCount() == 1) {
                           message = "Elvesztettél a veremben egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }
                   int step = hero.getStep();
                   step++;
                   hero.setStep(step);
               } else {
                   message = "Fal van előtted!";
               }
           }
           case North -> {
               FieldObject nextPlace = field.stream()
                       .filter(field -> field.getRow() == hero.getRow() - 1 && field.getColumn() == hero.getColumn()).toList().get(0);
               if (nextPlace.getShortCut() != 'W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if (nextPlace.getShortCut() == 'U') {
                       setGameOver(true); // a wumpus megölt
                       message = "A wumpus megölt!";
                   }
                   if (nextPlace.getShortCut() == 'G') {
                       message = "Jé! Itt van egy arany! Vedd fel!";
                   }
                   if (nextPlace.getShortCut() == 'P') {
                       if (hero.getArrowCount() == 1) {
                           message = "Elvesztettél a veremben egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }
                   int step = hero.getStep();
                   step++;
                   hero.setStep(step);
               } else {
                   message = "Fal van előtted!";
               }
           }
           default -> {
               FieldObject nextPlace = field.stream()
                       .filter(field -> field.getRow() == hero.getRow() && field.getColumn() == hero.getColumn() - 1).toList().get(0);
               if (nextPlace.getShortCut() != 'W') {
                   hero.setRow(nextPlace.getRow());
                   hero.setColumn(nextPlace.getColumn());
                   if (nextPlace.getShortCut() == 'U') {
                       setGameOver(true); // a wumpus megölt
                       message = "A wumpus megölt!";
                   }
                   if (nextPlace.getShortCut() == 'G') {
                       message = "Jé! Itt van egy arany! Vedd fel!";
                   }
                   if (nextPlace.getShortCut() == 'P') {
                       if (hero.getArrowCount() == 1) {
                           message = "Elvesztettél a veremben egy nyilat!";
                       }
                       hero.lostAnArrow();

                   }
                   int step = hero.getStep();
                   step++;
                   hero.setStep(step);
               } else {
                   message = "Fal van előtted!";
               }
           }
        }
        winStateChecker();
        return message;

    }


    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public boolean shootWithArrow() {
        switch (hero.getDirection()) {
            case East -> {
                List<FieldObject> filteredList = field.stream()
                        .filter(field -> field.getRow() == hero.getRow()).toList();
                boolean heKilledTheWumpus = false;
                // itt lesz gond az átlváltással 64->
                for (int i = hero.getColumn() - 65; i < hero.getMatrixLength(); i++) {
                    if (filteredList.get(i).getShortCut() != 'W') {
                        if (filteredList.get(i).getShortCut() == 'U') {
                            //találta a nyil
                            heKilledTheWumpus = true;
                            removeWumpusFromTheField();
                            break;
                        }
                    } else {
                        break;
                    }

                }
                hero.lostAnArrow();
                // ha true, akkor megöltem a wumpuszt, ha false,
                // akkor falnak ütközött a lövedékem, vagy nem volt nyilam
                return heKilledTheWumpus;
            }
            case South -> {
                boolean heKilledTheWumpus = false;
                List<FieldObject> filteredList = field.stream()
                        .filter(field -> field.getColumn() == hero.getColumn()).toList(); //azért mert vertikálisan haladok
                // kinyertem az oszlop azon sorait amiben a hős van
                for (int i = hero.getRow(); i < hero.getMatrixLength(); i++) {
                    if (filteredList.get(i).getShortCut() != 'W') {
                        if (filteredList.get(i).getShortCut() == 'U') {
                            //találta a nyil
                            heKilledTheWumpus = true;
                            removeWumpusFromTheField();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                hero.lostAnArrow();
                return heKilledTheWumpus;
            }
            case West -> {
                List<FieldObject> filteredList = field.stream()
                        .filter(field -> field.getRow() == hero.getRow()).toList();
                boolean heKilledTheWumpus = false;
                // itt lesz gond az átlváltással 64->0, azért nagyobb min 0,
                // mert a falat felesleges vizsgálni
                for (int i = hero.getColumn() - 65; i > 0; i--) {
                    if (filteredList.get(i).getShortCut() != 'W') {
                        if (filteredList.get(i).getShortCut() == 'U') {
                            //találta a nyil
                            heKilledTheWumpus = true;
                            removeWumpusFromTheField();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                hero.lostAnArrow();
                // ha true, akkor megöltem a wumpuszt, ha false,
                // akkor falnak ütközött a lövedékem, vagy nem volt nyilam
                return heKilledTheWumpus;
            }
            default -> {
                boolean heKilledTheWumpus = false;
                List<FieldObject> filteredList = field.stream()
                        .filter(field -> field.getColumn() == hero.getColumn()).toList(); //azért mert vertikálisan haladok
                for (int i = hero.getRow() - 1; i > 0; i--) {
                    if (filteredList.get(i).getShortCut() != 'W') {
                        if (filteredList.get(i).getShortCut() == 'U') {
                            //találta a nyil
                            heKilledTheWumpus = true;
                            removeWumpusFromTheField();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                hero.lostAnArrow();
                return heKilledTheWumpus;
            }
        }
    }

    private void removeWumpusFromTheField() {
        for (int i = 0; i < field.size(); i++) {
            if (field.get(i).getShortCut() == 'U') {
                field.get(i).setShortCut('_');
                break;
            }
        }
    }



}

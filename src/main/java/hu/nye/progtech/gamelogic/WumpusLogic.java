package hu.nye.progtech.gamelogic;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class WumpusLogic {
    List<FieldObject> field = new ArrayList<>();
    Hero hero = new Hero();

    int stepCounter = 0;

    public int getStepCounter() {
        return stepCounter;
    }

    FieldObject startFieldOfTheHero;

    boolean gameOver = false;
    boolean win = false;

    public boolean isWin() {
        return win;
    }

    int matrixLength = 0;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public WumpusLogic(LoadFrom loadFrom) {
        switch (loadFrom) {
            case file:
                FieldLoader loader = new FieldLoader();
                hero = loader.getHero();
                startFieldOfTheHero = new FieldObject(
                        hero.getShortCut(),
                        hero.getColumn(),
                        hero.getRow()
                ); // beállítjuk a kezdeti értéket, mert ez lesz a cél
                field = loader.getField();
                matrixLength = loader.getMatrixLength();
                break;
            default:
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
        if (hero.hasGold() && hero.getColumn() == startFieldOfTheHero.getColumn() && hero.getRow() == startFieldOfTheHero.getRow()) {
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
                    stepCounter++;
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
                   stepCounter++;
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
                    stepCounter++;
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
                   stepCounter++;
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
                for (int i = hero.getColumn() - 65; i < matrixLength; i++) {
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
                for (int i = hero.getRow(); i < matrixLength; i++) {
                    System.out.println(filteredList.get(i).getShortCut());
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
                    System.out.println(filteredList.get(i).getShortCut());
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

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    private boolean conditionForColoring(FieldObject fieldElement) {
        return fieldElement.getColumn() == hero.getColumn() && fieldElement.getRow() == hero.getRow();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public void drawField() {

        field.sort(Comparator
                .comparing(FieldObject::getRow)
                .thenComparing(FieldObject::getColumn));
        IntStream.range(0, matrixLength + 1).forEach(column -> {
            if ((column == 0)) {
                System.out.printf("%c\t", ' ');
            } else {
                System.out.printf("%3c", (char) column + 64);
            }

        });
        System.out.print("\n\n");
        field.forEach((fieldElement) -> {
            if (fieldElement.getColumn() - 64 == matrixLength) {
                if (fieldElement.getColumn() - 64 == 0) {
                    if (conditionForColoring(fieldElement)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n" + ConsoleColor.RESET, fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                } else {
                    if (conditionForColoring(fieldElement)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n" + ConsoleColor.RESET, fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                }

            } else {
                if (fieldElement.getColumn() == 'A') {
                    if (conditionForColoring(fieldElement)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%d\t" + ConsoleColor.RESET, fieldElement.getRow());
                    } else {
                        System.out.printf("%d\t", fieldElement.getRow());
                    }

                }
                if (conditionForColoring(fieldElement)) {
                    System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s" + ConsoleColor.RESET, fieldElement.getShortCut());
                } else {
                    System.out.printf("%3s", fieldElement.getShortCut());
                }

            }
        });
    }
}

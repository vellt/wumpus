package hu.nye.progtech.datacontrollers.filecontroller;

import java.util.Comparator;
import java.util.stream.IntStream;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.model.FieldObject;
import hu.nye.progtech.model.Hero;
import hu.nye.progtech.utils.ConsoleColor;


/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class FieldDrawer {

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    private static boolean conditionForColoring(FieldObject fieldElement, Hero hero) {
        return fieldElement.getColumn() == hero.getColumn() && fieldElement.getRow() == hero.getRow();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void draw(WumpusLogic wumpusLogic) {

        wumpusLogic.field.sort(Comparator
                .comparing(FieldObject::getRow)
                .thenComparing(FieldObject::getColumn));
        IntStream.range(0, wumpusLogic.hero.getMatrixLength() + 1).forEach(column -> {
            if ((column == 0)) {
                System.out.printf("%c\t", ' ');
            } else {
                System.out.printf("%3c", (char) column + 64);
            }

        });
        System.out.print("\n\n");
        wumpusLogic.field.forEach((fieldElement) -> {
            if (fieldElement.getColumn() - 64 ==  wumpusLogic.hero.getMatrixLength()) {
                if (fieldElement.getColumn() - 64 == 0) {
                    if (conditionForColoring(fieldElement, wumpusLogic.hero)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n" + ConsoleColor.RESET, fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                } else {
                    if (conditionForColoring(fieldElement, wumpusLogic.hero)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s\n" + ConsoleColor.RESET, fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                }

            } else {
                if (fieldElement.getColumn() == 'A') {
                    if (conditionForColoring(fieldElement, wumpusLogic.hero)) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%d\t" + ConsoleColor.RESET, fieldElement.getRow());
                    } else {
                        System.out.printf("%d\t", fieldElement.getRow());
                    }

                }
                if (conditionForColoring(fieldElement, wumpusLogic.hero)) {
                    System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND + "%3s" + ConsoleColor.RESET, fieldElement.getShortCut());
                } else {
                    System.out.printf("%3s", fieldElement.getShortCut());
                }

            }
        });
    }
}

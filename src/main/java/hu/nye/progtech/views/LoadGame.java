package hu.nye.progtech.views;

import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class LoadGame {

    public static boolean viewLoop = true;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println("*******LoadGame*********");
            System.out.println("Nincs implementálva-->kilépés");
            callback.call(1);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }


}

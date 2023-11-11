package hu.nye.progtech;

import hu.nye.progtech.views.*;

public class Main {
    public static void main(String[] args) {
        HomeView.show((isUserNameValid, userName) -> {
            if (isUserNameValid){
                MenuView.show(((chosenMenu) ->
                        switch (chosenMenu) {
                            case 1 -> FieldEditView.show();  // todo: elég vagy ezt vagy
                            case 2 -> FieldLoadFromFileView.show(userName);  // todo: ezt implementálni
                            case 3 -> LoadDataFromDbView.show();  // todo: ráér a 2. fázisban implementálni
                            case 4 -> SaveDataIntoDbView.show(); // todo: ráér a 2. fázisban implementálni
                            case 5 -> GameView.show(FieldLoadFromFileView.controller);
                            case 6 -> ExitView.show();
                            default -> ErrorView.show("Nem ismert menüpont");
                        }));
            }
        });
    }

}
package hu.nye.progtech.models;

public class Wumpus extends FieldObject{
    public Wumpus(char shortCut, char column, int row) {
        super(shortCut, column, row);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wumpus{");
        sb.append("shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        return sb.toString();
    }
}

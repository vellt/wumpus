package hu.nye.progtech.models;

/** verem */
public class Pit extends FieldObject {
    public Pit(char shortCut, char column, int row) {
        super(shortCut, column, row);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pit{");
        sb.append("shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        return sb.toString();
    }
}

package hu.nye.progtech.models;

public class Wall extends FieldObject{
    public Wall(char shortCut, char column, int row) {
        super(shortCut, column, row);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wall{");
        sb.append("shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        return sb.toString();
    }
}

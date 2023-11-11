package hu.nye.progtech.models;

public class Empty extends FieldObject{
    public Empty(char shortCut, char column, int row) {
        super(shortCut, column, row);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Empty{");
        sb.append("shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        return sb.toString();
    }
}

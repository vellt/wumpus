package hu.nye.progtech.models;

public class FieldObject {
    private char column;
    private int row;
    public FieldObject(char column, int row){
        this.column=column;
        this.row=row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}

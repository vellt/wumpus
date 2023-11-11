package hu.nye.progtech.models;

public class Hero extends FieldObject{
    private Direction direction;

    public Hero(char column, int row, Direction direction) {
        super(column, row);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

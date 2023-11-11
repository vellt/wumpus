package hu.nye.progtech.models;

public class Hero extends FieldObject{
    private Direction direction;

    public Hero(char shortCut, char column, int row, Direction direction) {
        super(shortCut, column, row);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("direction=").append(direction);
        sb.append("shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}

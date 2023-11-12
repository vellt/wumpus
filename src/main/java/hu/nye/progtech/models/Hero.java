package hu.nye.progtech.models;

public class Hero extends FieldObject{
    private Direction direction;
    private int arrowCount;

    private String name;

    public Hero(char shortCut, char column, int row, Direction direction, int arrowCount, String name) {
        super(shortCut, column, row);
        this.direction = direction;
        this.arrowCount = arrowCount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction turnRight(){
        if(this.getDirection().ordinal()!=3){
             this.setDirection(Direction.values()[this.getDirection().ordinal()+1]);
        }else{
            this.setDirection( Direction.values()[0]);
        }
        return this.getDirection();
    }

    public Direction turnLeft(){
        if(this.getDirection().ordinal()!=0){
            this.setDirection(Direction.values()[this.getDirection().ordinal()-1]);
        }else{
            this.setDirection( Direction.values()[3]);
        }
        return this.getDirection();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("name=").append(name);
        sb.append(", direction=").append(direction);
        sb.append(", arrowCount=").append(arrowCount);
        sb.append(", shortCut=").append(super.getShortCut());
        sb.append(", column=").append(super.getColumn());
        sb.append(", row=").append(super.getRow());
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}

package hu.nye.progtech.models;

import java.util.List;

public class Hero extends FieldObject{
    private Direction direction;
    private int arrowCount;

    private String name;

    private boolean hasGold=false;

    public Hero(char shortCut, char column, int row, Direction direction, int arrowCount, String name) {
        super(shortCut, column, row);
        this.direction = direction;
        this.arrowCount = arrowCount;
        this.name = name;
    }

    public Hero() {
        super('0', '0', 0);
        this.direction = Direction.East;
        this.arrowCount = 0;
        this.name = "";
    }

    public boolean hasGold() {
        return hasGold;
    }

    public void setThereIsGold(boolean hasGold) {
        this.hasGold = hasGold;
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

    public String getDirectionAsHU(){
        return switch (direction){
            case East -> "Nyugat";
            case South -> "Dél";
            case West -> "Kelet";
            default -> "Észak";
        };
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

    private  void decrementRowValue(){
        if(getRow()!=2){
            setRow(getRow()-1);
        }
    }

    private  void incrementRowValue(int maxRowValue){
        if(getRow()!=maxRowValue-1){
            setRow(getRow()+1);
        }
    }

    private void decrementColumnValue(){
        if(getRow()!='B'){
            setRow(getRow()-1);
        }
    }

    private  void incrementColumnValue(int maxColumnValue){
        if(getRow()!=maxColumnValue-1){
            setRow(getRow()+1);
        }
    }

    public void step(List<FieldObject> field){
        // adja vissza az új fieldlistát
        int maxRowAndColumn = field.stream()
                .mapToInt(FieldObject::getRow)
                .max()
                .orElse(0);
        switch (getDirection()){
            case North -> {
                decrementRowValue();
                event(field.get(0));
            }
            case South -> {
                incrementRowValue(maxRowAndColumn);
            }
            case West -> {
                decrementColumnValue();
            }
            default -> {
                incrementColumnValue(maxRowAndColumn+64);
            }
        }
        /*

        if(fieldObject.getShortCut()=='P'){
            lostAnArrow();
        }
        this.setColumn(fieldObject.getColumn());
        this.setRow(fieldObject.getColumn());

         */
    }

    private void event(FieldObject fieldObject) {
        switch (fieldObject.getShortCut()){
            case 'U':
                System.out.println("Game Over");
                break;
            case 'P':
                System.out.println("Vesztettél egy nyilat");
                lostAnArrow();
                break;
            case 'G':
                System.out.println("Ezen a helyen egy arany van, felételhez nyonjon b egy gombot");
                setThereIsGold(true);
                break;
            case '_':
                System.out.println("Nincs semmi");
                break;
        }
    }

    public boolean shoot(){
        return  true;
    }

    public int lostAnArrow(){
        if(getArrowCount()!=0){
            setArrowCount(getArrowCount()-1);
        }
        return getArrowCount();
    }

    public void stopGame(){

    }

    public void pauseGame(){
        
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("name=").append(name);
        sb.append(", direction=").append(direction);
        sb.append(", arrowCount=").append(arrowCount);
        sb.append(", shortCut=").append(this.getShortCut());
        sb.append(", column=").append(this.getColumn());
        sb.append(", row=").append(this.getRow());
        sb.append(", hasGold=").append(this.hasGold);
        sb.append('}');
        return sb.toString();
    }
}

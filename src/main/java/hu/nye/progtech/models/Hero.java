package hu.nye.progtech.models;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Hero extends FieldObject {
    private Direction direction;
    private int arrowCount;

    private String name;

    private boolean hasGold = false;

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

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public String getDirectionAsCharacter() {
        return switch (direction) {
            case East -> "→";
            case South -> "↓";
            case West -> "←";
            default -> "↑";
        };
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public Direction turnRight() {
        if (this.getDirection().ordinal() != 3) {
             this.setDirection(Direction.values()[this.getDirection().ordinal() + 1]);
        } else {
            this.setDirection(Direction.values()[0]);
        }
        return this.getDirection();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public Direction turnLeft() {
        if (this.getDirection().ordinal() != 0) {
            this.setDirection(Direction.values()[this.getDirection().ordinal() - 1]);
        } else {
            this.setDirection(Direction.values()[3]);
        }
        return this.getDirection();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public int lostAnArrow() {
        if (getArrowCount() != 0) {
            setArrowCount(getArrowCount() - 1);
        }
        return getArrowCount();
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

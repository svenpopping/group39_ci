package objects;

/**
 * Created by svenpopping on 13/10/14.
 */

public enum Direction {

    NORTH (-1, 0, 1),
    EAST (0, 1, 0),
    WEST (0, -1, 2),
    SOUTH (1, 0, 3);

    public final int drow, dcolumn, number;

    Direction (int drow, int dcolumn, int number) {
        this.drow = drow;
        this.dcolumn = dcolumn;
        this.number = number;
    }

    public Coordinate newCoordinate(Coordinate oldCoordinate) {
        return new Coordinate(oldCoordinate.getRow() + this.drow, oldCoordinate.getColumn() + this.dcolumn);
    }

    public Direction otherDirection(Direction direction) {
        if (direction == NORTH) return SOUTH;
        if (direction == SOUTH) return NORTH;
        if (direction == EAST) return WEST;
        if (direction == WEST) return EAST;
        return null;
    }

    public int getNumber() {
        return this.number;
    }

}

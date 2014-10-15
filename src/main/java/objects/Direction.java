package objects;

/**
 * Created by svenpopping on 13/10/14.
 */

public enum Direction {
    NORTH (-1, 0),
    EAST (0, 1),
    WEST (0, -1),
    SOUTH (1, 0);

    public final int drow, dcolumn;

    Direction (int drow, int dcolumn) {
        this.drow = drow;
        this.dcolumn = dcolumn;
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

}

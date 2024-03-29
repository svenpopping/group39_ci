package objects;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Coordinate {

    private int row, column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.row = coordinate.getRow();
        this.column = coordinate.getColumn();
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (column != that.column) return false;
        if (row != that.row) return false;

        return true;
    }

    @Override
    public Coordinate clone() {
        return new Coordinate(this.row, this.column);
    }

}

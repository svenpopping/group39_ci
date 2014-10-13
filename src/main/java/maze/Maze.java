package maze;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Maze {

    private Node[][] nodeTable;

    public Maze (int rows, int columns) {
        this.nodeTable = new Node[rows][columns];
    }

    public int getRowLength() {
        return this.nodeTable.length;
    }

    public int getColumnLength() {
        return this.nodeTable[0].length;
    }

    public void addNode(Coordinate coordinate, Node node) {
        if (this.nodeTable[coordinate.getRow()][coordinate.getColumn()] == null) {
            this.nodeTable[coordinate.getRow()][coordinate.getColumn()] = node;
        }
        return;
    }

    public Node getNode(Coordinate coordinate) {
        return this.nodeTable[coordinate.getRow()][coordinate.getColumn()];
    }

    @Override
    public String toString() {
        String string = "";
        for (int x = 0; x < nodeTable.length; x++) {
            for (int y = 0; y < nodeTable[x].length; y++) {
                if (nodeTable[x][y] != null) {
                    string += "[]";
                } else {
                    string += "  ";
                }
            }
            string += "\n";
        }
        return string;
    }
}

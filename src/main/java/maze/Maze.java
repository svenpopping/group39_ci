package maze;

import ants.Ant;
import objects.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Maze implements PheromoneInterface {

    public Node[][] nodeTable;
    public ArrayList<Node> deadEndPaths;
    public ArrayList<Ant> antsAtStopPosition = new ArrayList<Ant>();

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

    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodeArrayList = new ArrayList<Node>();
        for (Node[] nodes : this.nodeTable) {
            for (Node node : nodes) {
                nodeArrayList.add(node);
            }
        }
        return nodeArrayList;
    }

    @Override
    public String toString() {
        String string = "";
        for (int x = 0; x < nodeTable.length; x++) {
            for (int y = 0; y < nodeTable[x].length; y++) {
                if (nodeTable[x][y] != null) {
                    if (nodeTable[x][y].isKnot())
                        string += "[x]";
                    else
                        string += "[ ]";
                } else {
                    string += "   ";
                }
            }
            string += "\n";
        }
        return string;
    }

    @Override
    public void increasePheromone(Coordinate coordinate) {
        this.getNode(coordinate).increasePheromone(10);
    }

    @Override
    public void addDeadEnd(Node node) {
        this.deadEndPaths.add(node);
    }

    @Override
    public void antsAtStopPosition(Ant ant) {
        this.antsAtStopPosition.add(ant);
    }

    @Override
    public void updatePheromone() {
        for (Node node : this.getNodes()) {
            if (node != null)
                node.updatePheromone();
        }
    }

}

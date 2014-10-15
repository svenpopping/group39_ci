package maze;

import objects.Direction;

import java.util.ArrayList;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Node {

    private Node north, east, south, west;
    private int pheromone = 0;

    public Node() {
        super();
    }

    public Node getNorth() {
        return north;
    }

    public void setNorth(Node north) {
        this.north = north;
    }

    public Node getEast() {
        return east;
    }

    public void setEast(Node east) {
        this.east = east;
    }

    public Node getSouth() {
        return south;
    }

    public void setSouth(Node south) {
        this.south = south;
    }

    public Node getWest() {
        return west;
    }

    public void setWest(Node west) {
        this.west = west;
    }

    public void increasePheromone() {
        this.pheromone++;
    }

    public int getPheromone() {
        return this.pheromone;
    }

    public Node getDirectionNode(Direction direction) {
        if (direction.equals(Direction.EAST)) return this.east;
        if (direction.equals(Direction.NORTH)) return this.north;
        if (direction.equals(Direction.SOUTH)) return this.south;
        if (direction.equals(Direction.WEST)) return this.west;
        return null;
    }

    public ArrayList<Direction> getPossibleDirections() {
        ArrayList<Direction> dirs = new ArrayList<Direction>();

        if (this.east != null)
            dirs.add(Direction.EAST);

        if (this.north != null)
            dirs.add(Direction.NORTH);

        if (this.west != null)
            dirs.add(Direction.WEST);

        if (this.south != null)
            dirs.add(Direction.SOUTH);

        return dirs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!east.equals(node.east)) return false;
        if (!north.equals(node.north)) return false;
        if (!south.equals(node.south)) return false;
        if (!west.equals(node.west)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Node{" +
                "north=" + north +
                ", east=" + east +
                ", south=" + south +
                ", west=" + west +
                '}';
    }
}

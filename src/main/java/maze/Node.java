package maze;

import objects.Direction;

import java.util.ArrayList;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Node {

    private Node north, east, south, west;
    private float pheromone = 1;
    private float evaporation = 0;

    private ArrayList<Direction> surroundingNodes = new ArrayList<Direction>();

    private boolean knot = false;

    public Node(float evaporation) {
        super();
        this.evaporation = evaporation;


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

    public boolean isKnot() {
        return knot;
    }

    public void setKnot(boolean knot) {
        this.knot = knot;
    }

    public void increasePheromone(int pheromone) {
        if (this.pheromone != 0)
            this.pheromone += pheromone;
    }

    public void setPheromone(int pheromone) {
        this.pheromone = pheromone;
    }

    public void updatePheromone() {
        this.pheromone = (1 - this.evaporation) * this.pheromone;
    }

    public float getPheromone() {
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
        this.surroundingNodes.clear();
        if (this.surroundingNodes.size() == 0) {
            if (this.east != null && this.east.getPheromone() != 0)
                surroundingNodes.add(Direction.EAST);

            if (this.west != null && this.west.getPheromone() != 0)
                surroundingNodes.add(Direction.WEST);

            if (this.south != null && this.south.getPheromone() != 0)
                surroundingNodes.add(Direction.SOUTH);

            if (this.north != null && this.north.getPheromone() != 0)
                surroundingNodes.add(Direction.NORTH);
        }
        return this.surroundingNodes;
    }

}

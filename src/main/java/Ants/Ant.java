package ants;

import java.util.ArrayList;

import maze.Node;
import maze.PheromoneInterface;
import objects.Coordinate;
import objects.Direction;

public abstract class Ant {
	
	protected Coordinate coordinate, stopPosition, startPosition;
	protected ArrayList<Direction> antPath;
	protected ArrayList<Node> antPathNodes;
    protected int maxPathLength;
    protected Node currentNode;

    protected PheromoneInterface pheromone;

    protected boolean atStopCoordinate = false;
	
	public Ant(Coordinate start, Coordinate stop, int maxPathLength){
		this.coordinate = start;
        this.startPosition = start.clone();
		this.stopPosition = stop;
        this.maxPathLength = maxPathLength;

        this.antPath = new ArrayList<Direction>();
        this.antPathNodes = new ArrayList<Node>();
	}
	
	public abstract void walk(Node node);
	
	public void addPath(Direction dir){
		this.antPath.add(dir);
	}

    public void addNodePath(Node node) {
        this.antPathNodes.add(node);
    }

    public void setPheromone(PheromoneInterface pheromone) {
        this.pheromone = pheromone;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public static Direction getOppositeDirection(Direction direction) {
        if (direction.equals(Direction.EAST)) return Direction.WEST;
        if (direction.equals(Direction.WEST)) return Direction.EAST;
        if (direction.equals(Direction.SOUTH)) return Direction.NORTH;
        if (direction.equals(Direction.NORTH)) return Direction.SOUTH;
        return null;
    }

    public void setAtStopCoordinate(boolean flag) {
        this.atStopCoordinate = flag;
    }

    public boolean isAtStopCoordinate() {
        return this.atStopCoordinate;
    }

    public String getAntPath() {
        String string = "";
        for (Direction dir : antPath) {
            string += dir.getNumber() + ";";
        }
        return string;
    }

    public ArrayList<Node> getAntPathNodes() {
        return this.antPathNodes;
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }

    @Override
    public String toString() {
        return "Ant@" + this.getCoordinate().toString();
    }

    public Coordinate getStopPosition() {
        return stopPosition;
    }

    public Coordinate getStartPosition() {
        return startPosition;
    }

    public void setStopPosition(Coordinate stopPosition) {
        this.stopPosition = stopPosition;
    }

    public void setStartPosition(Coordinate startPosition) {
        this.startPosition = startPosition;
    }
}

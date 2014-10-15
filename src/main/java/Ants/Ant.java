package ants;

import java.util.ArrayList;

import maze.Node;
import maze.PheromoneInterface;
import objects.Coordinate;
import objects.Direction;

public abstract class Ant {
	
	protected Coordinate coordinate;
	protected ArrayList<Direction> antPath;

    protected PheromoneInterface pheromone;
	
	public Ant(int row, int column){
		this.coordinate = new Coordinate(row, column);
        this.antPath = new ArrayList<Direction>();
	}
	
	public abstract void walk(Node node);
	
	public void addPath(Direction dir){
		this.antPath.add(dir);
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

}

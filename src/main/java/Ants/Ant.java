package ants;

import java.util.ArrayList;

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
	
	public abstract void walk(ArrayList<Direction> dir);
	
	public void addPath(Direction dir){
		this.antPath.add(dir);
	}

    public void setPheromone(PheromoneInterface pheromone) {
        this.pheromone = pheromone;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

}

package Ants;

import java.util.ArrayList;

import maze.Coordinate;

public abstract class Ant {
	
	protected Coordinate coordinate;
	protected ArrayList<Coordinate> AntPath;
	
	public Ant(int row, int column){
		this.coordinate = new Coordinate(row, column);
	}
	
	public abstract void walk();
	
	public void Path(){
		AntPath = new ArrayList<Coordinate>();
	}
	
	public void addPath(Coordinate last){
		AntPath.add(last);
	}
}

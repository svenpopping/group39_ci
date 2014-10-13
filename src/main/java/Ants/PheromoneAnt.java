package Ants;

import java.util.Random;

import maze.Coordinate;

public class PheromoneAnt extends Ant {

	/**
	 * Method walk() lets a ScoutAnt walk in a certain direction.
	 * @param dir - The direction.
	 */
	public void walk(Direction[] dir) {
		
		int sizeDirection = dir.size();
		Direction direction = dir[new Random().nextInt(dir.length)];
		
		addPath(direction);
		
		if ( dir == NORTH ){
			super.coordinate.setColumn(super.coordinate.getColumn() + 1);
		}
		
		if ( dir == SOUTH ) {
			super.coordinate.setColumn(super.coordinate.getColumn() - 1);
		}
		
		if ( dir == EAST ){
			super.coordinate.setRow(super.coordinate.getRow() + 1);
		}
		
		if ( dir == WEST ){
			super.coordinate.setRow(super.coordinate.getRow() - 1);
		}
		
		maze.getNode().increasePheromone();
	}
	
	public void pheromone(Coordinate crd){
		Coordinate.pheromone = Coordinate.pheromone + 1;
	}
}

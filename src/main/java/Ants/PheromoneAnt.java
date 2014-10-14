package ants;

import java.util.ArrayList;
import java.util.Random;

import objects.Coordinate;
import objects.Direction;

public class PheromoneAnt extends Ant {

    public PheromoneAnt(int row, int column) {
        super(row, column);
    }

	/**
	 * Method walk() lets a ScoutAnt walk in a certain direction.
	 * @param dir - The direction.
	 */
	public void walk(ArrayList<Direction> dir) {
        Direction direction = dir.get(new Random().nextInt(dir.size()));

        super.coordinate.setCoordinate(direction.newCoordinate(this.coordinate));

//		if ( direction == Direction.NORTH ) {
//            super.coordinate.setColumn(super.coordinate.getColumn() + 1);
//        }
//		if ( direction == Direction.SOUTH ) {
//			super.coordinate.setColumn(super.coordinate.getColumn() - 1);
//		}
//		if ( direction == Direction.EAST ) {
//            super.coordinate.setRow(super.coordinate.getRow() + 1);
//        }
//		if ( direction == Direction.WEST ) {
//            super.coordinate.setRow(super.coordinate.getRow() - 1);
//        }

        super.pheromone.increasePheromone(this.coordinate);
	}

}

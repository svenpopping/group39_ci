package ants;

import objects.Direction;

import java.util.ArrayList;
import java.util.Random;

public class ScoutAnt extends Ant {

    public ScoutAnt(int row, int column) {
        super(row, column);
    }

    /**
     * Method walk() lets a ScoutAnt walk in a certain direction.
     * @param dir - The direction.
     */
    @Override
    public void walk(ArrayList<Direction> dir) {
        Direction direction = dir.get(new Random().nextInt(dir.size()));

        if (super.antPath.size() != 0) {
            while (direction.otherDirection(super.antPath.get(super.antPath.size() - 1)).equals(direction)) {
                direction = dir.get(new Random().nextInt(dir.size()));
            }
        }

        super.addPath(direction);
        super.coordinate.setCoordinate(direction.newCoordinate(this.coordinate));
        super.pheromone.increasePheromone(this.coordinate);
    }
}

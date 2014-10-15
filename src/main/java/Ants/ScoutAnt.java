package ants;

import maze.Node;
import objects.Direction;

import java.util.ArrayList;
import java.util.Random;

public class ScoutAnt extends Ant {

    public ScoutAnt(int row, int column) {
        super(row, column);
    }

    /**
     *
     * @param node
     */
    @Override
    public void walk(Node node) {
        ArrayList<Direction> directions = node.getPossibleDirections();
        Direction direction;
        if (directions.size() == 2 && !super.antPath.isEmpty()) {
            int position = directions.indexOf(getOppositeDirection(super.antPath.get(super.antPath.size() - 1)));
            position = Math.abs(1 - position);
            direction = directions.get(position);

            super.addPath(direction);
            super.coordinate.setCoordinate(direction.newCoordinate(this.coordinate));
            super.pheromone.increasePheromone(this.coordinate);

            if (node.getDirectionNode(direction).getPossibleDirections().size() == 2) {
                walk(node.getDirectionNode(direction));
            }
        } else {
            direction = directions.get(new Random().nextInt(directions.size()));
            if (super.antPath.size() != 0 && directions.size() != 1) {
                while (direction.otherDirection(super.antPath.get(super.antPath.size() - 1)).equals(direction)) {
                    direction = directions.get(new Random().nextInt(directions.size()));
                }
            }
            super.addPath(direction);
            super.coordinate.setCoordinate(direction.newCoordinate(this.coordinate));
            super.pheromone.increasePheromone(this.coordinate);

            if (node.getDirectionNode(direction).getPossibleDirections().size() == 2) {
                walk(node.getDirectionNode(direction));
            }
        }
    }
}

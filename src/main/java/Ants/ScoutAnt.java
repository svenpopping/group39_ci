package ants;

import maze.Node;
import objects.Coordinate;
import objects.Direction;

import java.util.ArrayList;
import java.util.Random;

public class ScoutAnt extends Ant {

    public ScoutAnt(Coordinate start, Coordinate stop, int maxPathLength) {
        super(start, stop, maxPathLength);
    }

    /**
     *
     * @param node
     */
    @Override
    public void walk(Node node) {
        ArrayList<Direction> directions = node.getPossibleDirections();
        Direction direction = directions.get(new Random().nextInt(directions.size()));

        if (directions.size() != 1 && super.antPath.size() > 2) {
            while (direction.otherDirection(super.antPath.get(super.antPath.size() - 1)).equals(direction)
                    && node.getDirectionNode(direction).getPheromone() != 0) {
                direction = directions.get(new Random().nextInt(directions.size()));
            }
        } else if (directions.size() == 1) {
            if (!this.coordinate.equals(this.stopPosition))
                node.setPheromone(0);
        }

        addPath(direction);
        addNodePath(node.getDirectionNode(direction));
        coordinate.setCoordinate(direction.newCoordinate(this.coordinate));

        if (this.stopPosition.equals(this.coordinate)) {
            this.setAtStopCoordinate(true);
            for (Node path : this.antPathNodes) {
                path.increasePheromone(this.maxPathLength / this.antPathNodes.size());
            }
            System.out.println("finished in: " + this.getAntPathNodes().size() + " walked " + this.getAntPath());
        }
    }
}

package ants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

import maze.Node;
import objects.Coordinate;
import objects.Direction;

public class PheromoneAnt extends Ant {

    public PheromoneAnt(Coordinate start, Coordinate stop, int maxPathLength) {
        super(start, stop, maxPathLength);
    }

	/**
	 * Method walk() lets a Phermone walk in a certain direction.
	 * @param node - The next Node.
	 */
	public void walk(Node node) {
        ArrayList<Direction> directions = node.getPossibleDirections();
        ArrayList<Float> changes = new ArrayList<Float>();

        float totalPhermone = 0;
        for (Direction dir : directions) {
            totalPhermone += node.getDirectionNode(dir).getPheromone();
        }
        for (Direction dir : directions) {
            changes.add(node.getDirectionNode(dir).getPheromone() / totalPhermone);
        }

        Direction direction = Direction.EAST;
        if (directions.size() != 1 && super.antPath.size() != 0) {
            direction = directions.get(this.getRandomIndex(changes));
            while (direction.otherDirection(super.antPath.get(super.antPath.size() - 1)).equals(direction)
                    && node.getDirectionNode(direction).getPheromone() != 0) {
                direction = directions.get(new Random().nextInt(directions.size()));
            }
            direction = directions.get(this.getRandomIndex(changes));
        }  else if (directions.size() == 1 ) {
            if (!this.coordinate.equals(this.stopPosition))
                node.setPheromone(0);
        }

        addPath(direction);
        addNodePath(node.getDirectionNode(direction));
        coordinate.setCoordinate(direction.newCoordinate(this.coordinate));

        if (this.stopPosition.equals(this.coordinate)) {
            setAtStopCoordinate(true);
            pheromone.updatePheromone();
            for (Node path : this.antPathNodes) {
                path.increasePheromone(this.maxPathLength / this.antPathNodes.size());
            }
            System.out.println("PhermoneAnt finished in: " + this.getAntPathNodes().size() + " started at: " + this.getStartPosition().toString());
        }
    }

    public int getRandomIndex(ArrayList<Float> changes) {
        int randomIndex = 0;
        double random = Math.random();
        for (int i = 0; i < changes.size(); ++i)
        {
            random -= changes.get(i);
            if (random <= 0.0d)
            {
                randomIndex = i;
                break;
            }
        }
        return randomIndex;
    }

}

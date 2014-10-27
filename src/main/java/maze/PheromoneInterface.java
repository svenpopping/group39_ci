package maze;

import ants.Ant;
import objects.Coordinate;

/**
 * Created by svenpopping on 13/10/14.
 */
public interface PheromoneInterface {

    public void increasePheromone(Coordinate coordinate);

    public void addDeadEnd(Node node);

    public void antsAtStopPosition(Ant ant);

    public void updatePheromone();

}

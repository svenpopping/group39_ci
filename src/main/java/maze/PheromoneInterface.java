package maze;

import objects.Coordinate;

/**
 * Created by svenpopping on 13/10/14.
 */
public interface PheromoneInterface {

    public void increasePheromone(Coordinate coordinate);

    public void addDeadEnd(Node node);

}

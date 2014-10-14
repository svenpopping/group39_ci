package setup;

import ants.Ant;
import ants.PheromoneAnt;
import ants.ScoutAnt;
import maze.Maze;
import maze.MazeParser;
import maze.Node;
import objects.Coordinate;
import objects.Direction;

import java.util.ArrayList;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Setup {

    private Maze maze;
    private ArrayList<ScoutAnt> scoutAnts = new ArrayList<ScoutAnt>();
    private ArrayList<PheromoneAnt> phermoneAnts = new ArrayList<PheromoneAnt>();

    public Setup(String filePath, int scout, int phermone) {
        this.maze = MazeParser.parseMaze(filePath);

        for (int i = 0; i < scout; i++) {
            ScoutAnt scoutAnt = new ScoutAnt(0, 0);
            this.scoutAnts.add(scoutAnt);
            scoutAnt.setPheromone(this.maze);
        }
    }

    public void step() {
        for (ScoutAnt scoutAnt : scoutAnts) {
            Coordinate coordinate = scoutAnt.getCoordinate();

            Node node = this.maze.getNode(coordinate);
            ArrayList<Direction> directions = new ArrayList<Direction>();

            if (node.getEast() != null) directions.add(Direction.EAST);
            if (node.getNorth() != null) directions.add(Direction.NORTH);
            if (node.getWest() != null) directions.add(Direction.WEST);
            if (node.getSouth() != null) directions.add(Direction.SOUTH);
            
            scoutAnt.walk(directions);
        }
    }

    public Maze getMaze() {
        return maze;
    }

    public String toString() {
        String string = "";
        for (int x = 0; x < this.maze.nodeTable.length; x++) {
            for (int y = 0; y < this.maze.nodeTable[x].length; y++) {
                for (ScoutAnt scoutAnt : this.scoutAnts) {
                    if (scoutAnt.getCoordinate().getRow() == x && scoutAnt.getCoordinate().getColumn() == y) {
                        string += "[x]";
                    }
                    break;
                }

                if (this.maze.nodeTable[x][y] != null) {
                    string += "[ ]";
                } else {
                    string += "   ";
                }
            }
            string += "\n";
        }
        return string;
    }



}

package setup;

import ants.Ant;
import ants.PheromoneAnt;
import ants.ScoutAnt;
import maze.Maze;
import maze.MazeParser;
import maze.Node;
import objects.Coordinate;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Setup {

    private Maze maze;

    private Coordinate startPosition, stopPosition;
    private int maxPathLength;

    private ArrayList<Ant> ants = new ArrayList<Ant>();

    public Setup(String filePath, double scout, float evaporation, int maxPathLength) {
        this.maze = MazeParser.parseMaze("src/main/resources/" + filePath + "_maze.txt", evaporation);
        Coordinate[] coordinates = MazeParser.getCoordinates("src/main/resources/" + filePath + "_coordinates.txt");

        this.startPosition = coordinates[0];
        this.stopPosition = coordinates[1];
        this.maxPathLength = maxPathLength;

        for (int i = 0; i < scout; i++) {
            ScoutAnt scoutAnt = new ScoutAnt(this.startPosition.clone(), this.stopPosition.clone(), maxPathLength);
            this.ants.add(scoutAnt);
            scoutAnt.setPheromone(this.maze);
        }
    }

    public void step() {
        for (Ant ant : this.ants) {
            for (int i = 0; i < ant.getMaxPathLength(); i++) {
                if (ant.isAtStopCoordinate() == false) {
                    ant.walk(this.maze.getNode(ant.getCoordinate()));
                } else {
                    int pheromone = Math.round(ant.getMaxPathLength() / ant.getAntPathNodes().size());
                    if (pheromone > 1) {
                        for (Node node : ant.getAntPathNodes()) {
                            node.increasePheromone(pheromone);
                        }
                    }
                    break;
                }
            }
        }
        walkBack();
    }

    public void resetAnts(int scout, int maxPathLength) {
        this.ants.clear();
        for (int i = 0; i < scout; i++) {
            PheromoneAnt scoutAnt = new PheromoneAnt(this.startPosition.clone(), this.stopPosition.clone(), maxPathLength);
            this.ants.add(scoutAnt);
            scoutAnt.setPheromone(this.maze);
        }
    }

    public void walkBack() {
        for (Ant ant : this.ants) {
            if (ant.isAtStopCoordinate()) {
                PheromoneAnt pheromoneAnt = new PheromoneAnt(this.stopPosition.clone(), this.startPosition.clone(), maxPathLength);
                pheromoneAnt.setPheromone(this.maze);

                for (int i = 0; i < pheromoneAnt.getMaxPathLength(); i++) {
                        if (pheromoneAnt.isAtStopCoordinate() == false)
                        try {
                            pheromoneAnt.walk(this.maze.getNode(pheromoneAnt.getCoordinate()));
                        } catch (Exception e) { break; }
                    else {
                        int pheromone = Math.round(ant.getMaxPathLength() / ant.getAntPathNodes().size());
                        if (pheromone > 1) {
                            for (Node node : ant.getAntPathNodes()) {
                                node.increasePheromone(pheromone);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public Maze getMaze() {
        return maze;
    }

    public ArrayList<Ant> getAnts() {
        return this.ants;
    }

    public String toString() {
        String string = "";
        for (int x = 0; x < this.maze.nodeTable.length; x++) {
            for (int y = 0; y < this.maze.nodeTable[x].length; y++) {
                boolean ant = false;
                for (Ant scoutAnt : this.ants) {
                    if (scoutAnt.getCoordinate().getRow() == x && scoutAnt.getCoordinate().getColumn() == y) {
                        string += "[ ANT ]";
                        ant = true;
                        break;
                    }
                }
                if (!ant) {
                    if (this.maze.nodeTable[x][y] != null) {
                        int phermone = Math.round(this.maze.nodeTable[x][y].getPheromone());
                        if (phermone < 10) {
                            string += "[0000" + phermone +"]";
                        } else if (phermone < 100) {
                            string += "[000" + phermone +"]";
                        } else if (phermone < 1000) {
                            string += "[00" + phermone + "]";
                        } else if (phermone < 10000) {
                            string += "[0" + phermone + "]";
                        } else {
                            string += "[" + phermone + "]";
                        }
                    } else {
                        string += "       ";
                    }
                }
            }
            string += "\n";
        }
        return string;
    }

}

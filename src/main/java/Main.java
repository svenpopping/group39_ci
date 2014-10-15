import maze.MazeParser;
import objects.Coordinate;
import maze.Maze;
import maze.Node;
import setup.Setup;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Main {

    private double iterations, ants, phermone, evaporation, cc;

    public static void main(String[] args) {
        double iterations, ants, phermone, evaporation, cc;
        iterations = 250;
        
        Setup setup = new Setup("src/main/resources/easy_maze.txt", 10, 0);

        for(int x = 0; x < iterations; x++) {
            setup.step();
        }
        System.out.println(setup.toString());
    }


}

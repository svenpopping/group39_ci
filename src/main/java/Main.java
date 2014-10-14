import maze.MazeParser;
import objects.Coordinate;
import maze.Maze;
import maze.Node;
import setup.Setup;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Main {

    public static void main(String[] args) {
        Setup setup = new Setup("src/main/resources/easy_maze.txt", 1, 0);
        setup.step();
        setup.step();
        setup.step();
        setup.step();
        setup.step();
        setup.step();
        setup.step();
        setup.step();
        System.out.println(setup.toString());
    }


}

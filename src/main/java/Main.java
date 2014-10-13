import maze.Coordinate;
import maze.Maze;
import maze.Node;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze(2, 2);
        Node node = new Node();

        maze.addNode(new Coordinate(0, 1), node);

        System.out.println(maze);
    }

}

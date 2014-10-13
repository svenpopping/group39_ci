package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by svenpopping on 13/10/14.
 */
public class MazeParser {

    public static Maze parseMaze(String filePath) {
        BufferedReader reader;

        try {
            File file = new File(filePath);
            reader = new BufferedReader(new FileReader(file));

            String[] sizeLine = reader.readLine().split(", ");
            Maze maze = new Maze(Integer.valueOf(sizeLine[1]) + 1, Integer.valueOf(sizeLine[0]) + 1);
            
            for (int row = 0; row <= Integer.valueOf(sizeLine[1]); row++) {
                String[] fields = reader.readLine().split(" ");
                for (int column = 0; column < fields.length; column++) {
                    if (fields[column].equals("1")) {
                        maze.addNode(new Coordinate(row, column), new Node());
                    }
                }
            }
            return connectNodes(maze);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Maze connectNodes(Maze maze) {
        for (int row = 0; row < maze.getRowLength(); row++) {
            for (int column = 0; column < maze.getColumnLength(); column++) {
                Node node = maze.getNode(new Coordinate(row, column));

                if (column + 1 < maze.getColumnLength())
                    try {
                        node.setEast(maze.getNode(new Coordinate(row, column + 1)));
                    } catch
                    

                if ( row - 1 >= 0)
                    node.setNorth(maze.getNode(new Coordinate(row - 1, column)));

                if ( column - 1 >= 0)
                    node.setWest(maze.getNode(new Coordinate(row, column - 1)));

                if ( row + 1 < maze.getRowLength())
                    node.setSouth(maze.getNode(new Coordinate(row + 1, column)));
            }
        }
        return maze;
    }

    public static void main(String[] args) {
        parseMaze("src/main/resources/easy_maze.txt");
    }

}

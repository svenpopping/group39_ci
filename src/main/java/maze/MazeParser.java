package maze;

import objects.Coordinate;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by svenpopping on 13/10/14.
 */
public class MazeParser {

    public static Maze parseMaze(String filePath, float evaporation) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filePath));

            String[] sizeLine = reader.readLine().split(" ");
            Maze maze = new Maze(Integer.valueOf(sizeLine[1]), Integer.valueOf(sizeLine[0]));
            
            for (int row = 0; row < Integer.valueOf(sizeLine[1]); row++) {
                String[] fields = reader.readLine().split(" ");
                for (int column = 0; column < fields.length; column++) {
                    if (fields[column].equals("1")) {
                        maze.addNode(new Coordinate(row, column), new Node(evaporation));
                    }
                }
            }
            connectNodes(maze);
            return maze;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Coordinate[] getCoordinates(String filePath) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            Coordinate[] coordinates = new Coordinate[2];
            for (int i = 0; i < 2; i++) {
                String[] fields = reader.readLine().split(", ");
                coordinates[i] = new Coordinate(Integer.valueOf(fields[1].substring(0, fields[1].length()-1)), Integer.valueOf(fields[0]));
            }
            return coordinates;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Maze connectNodes(Maze maze) {
        for (int row = 0; row < maze.getRowLength(); row++) {
            for (int column = 0; column < maze.getColumnLength(); column++) {
                Node node = maze.getNode(new Coordinate(row, column));
                int connection = 0;

                if (column + 1 < maze.getColumnLength())
                    try {
                        node.setEast(maze.getNode(new Coordinate(row, column + 1)));
                        if (node.getEast() != null) connection++;
                    } catch (NullPointerException e) {}

                if ( row - 1 >= 0)
                    try {
                        node.setNorth(maze.getNode(new Coordinate(row - 1, column)));
                        if (node.getNorth() != null) connection++;
                    } catch (NullPointerException e) {}


                if ( column - 1 >= 0)
                    try {
                        node.setWest(maze.getNode(new Coordinate(row, column - 1)));
                        if (node.getWest() != null) connection++;
                    } catch (NullPointerException e) {}

                if ( row + 1 < maze.getRowLength())
                    try {
                        node.setSouth(maze.getNode(new Coordinate(row + 1, column)));
                        if (node.getSouth() != null) connection++;
                    } catch (NullPointerException e) {}
            }
        }
        return maze;
    }

}

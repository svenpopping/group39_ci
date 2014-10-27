import ants.Ant;
import ants.ScoutAnt;
import setup.Setup;

import java.util.ArrayList;

/**
 * Created by svenpopping on 13/10/14.
 */
public class Main {

    public static void main(String[] args) {
        float phermone, evaporation;
        int ants, cc, iterations;
        String maze;

        /**
         *
         */
        iterations = 100;
        ants = 100;
        phermone = 1;
        evaporation = 0.2f;
        cc = 20000;
        maze = "hard";

        Setup setup = new Setup(maze, ants, evaporation, cc);
        setup.step();

        for (int i = 0; i < iterations; i++) {
            System.out.println("========== [" + i + "] ==========");
            setup.resetAnts(ants, cc);
            setup.step();
        }
        System.out.println(setup.toString());
    }

}

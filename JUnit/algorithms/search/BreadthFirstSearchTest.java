package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BreadthFirstSearchTest {
    private BreadthFirstSearch Breath = new BreadthFirstSearch();

    @Test
    public void TimeTest() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(1000, 1000);
        SearchableMaze runner = new SearchableMaze(maze);
        assertTrue(Breath.measureAlgorithmTimeMillisSearch(runner) < 6000);


    }

    @Test
    public void inpuTest() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(-1, 2);
        assertNull(maze, "Maze must be null for invalid input dimensions");
    }

}


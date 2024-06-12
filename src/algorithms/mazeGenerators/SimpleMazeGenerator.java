package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int row, int col) {
        try {
            if(row<2||col<2){
                throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
            }
            Position StartPoint = new Position(0, 0);
            Position GoalPoint = new Position(row - 1, col - 1);
            Maze maze = new Maze(row, col, StartPoint, GoalPoint);
            Random rand = new Random();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze.SetPoint(i, j, rand.nextInt(2));
                }
            }
            maze.SetPoint(0, 0, 0);
            maze.SetPoint(row - 1, col - 1, 0);         //making sure the start and goals are paths
            return maze;
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
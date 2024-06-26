package algorithms.mazeGenerators;

import java.util.Random;

public class Sketch {
    public class SimpleMazeGenerator extends AMazeGenerator{
        @Override
        public Maze generate(int row, int col) {


            try {
                if(row<2||col<2){
                    throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
                }
                Position StartPoint = setPointonEdge(row,col);
                Position GoalPoint;
                do{
                    GoalPoint=setPointonEdge(row,col);

                } while(StartPoint.equals(GoalPoint));

                Maze maze = new Maze(row, col, StartPoint, GoalPoint);
                Random rand = new Random();
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        maze.setToTwo(i,j);
                        maze.setPoint(i, j, rand.nextInt(2));
                    }
                }
                return maze;
            }catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
                return null;
            }
        }
    }
}
